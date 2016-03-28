package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.example.ChangePasswordPage;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.example.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

@Test
public class ChangePasswordTest extends TestBase {

    private LoginView loginPage=new LoginView();
    private ChangePasswordPage changePasswordPage =new ChangePasswordPage();
    private NavigationBarPage navigationBarPage = new NavigationBarPage();

    private void openUrl() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }

    @Test
    public void successChangePasswordTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword("eu.pass", "eu.pass2");

        changePasswordPage.assertThatErrorIs("Your password has been successfully changed.");
        changePasswordPage.closePreferenceWindows();
    }

    @Test
    public void oldPasswordIsWrongTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword("eu.passWrong", "eu.pass2");

        changePasswordPage.assertThatErrorIs("Your preview password is incorrect!");
    }

    @Test
    public void oldPasswordFieldEmptyTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword("", "eu.pass2");

        changePasswordPage.assertThatErrorIs("Your preview password is incorrect!");
    }

    @Test
    public void newConfirmedPasswordFieldEmptyTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword("","");

        changePasswordPage.assertThatErrorIs("Empty fields!");
    }

    @Test
    public void repeatPasswordIsWrongTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword3Param("eu.pass", "eu.pass2", "abcdefg");

        changePasswordPage.assertThatErrorIs("Password does not match the confirm password!");
        changePasswordPage.closePreferenceWindows();
    }
}
