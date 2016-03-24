package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.ChangePasswordPage;
import org.fasttrackit.example.LoginPage;
import org.fasttrackit.example.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;
    private NavigationBarPage navigationBarPage;

    //right click -> Generate -> Constructor
    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        navigationBarPage = PageFactory.initElements(driver, NavigationBarPage.class);
    }

    private void openUrl() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


    @Test
    public void successChangePasswordTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword("eu.pass", "eu.pass2");

        String statusElementText = changePasswordPage.getStatusMessage();

        System.out.println(statusElementText);
        assertThat(statusElementText, is("Your password has been successfully changed."));
    }


    @Test
    public void oldPasswordIsWrongTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword("eu.passWrong", "eu.pass2");

        String statusElementText = changePasswordPage.getStatusMessage();

        System.out.println(statusElementText);
        assertThat(statusElementText, is("Your preview password is incorrect!"));
    }

    //bug - if I let empty the new passord and repeat password  - Save  => Your password has been successfully changed.

    @Test
    public void repeatPasswordIsWrongTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigationBarPage.openPreferencesWindow();
        changePasswordPage.changePassword3Param("eu.pass", "eu.pass2","abcdefg");

        String statusElementText = changePasswordPage.getStatusMessage();

        System.out.println(statusElementText);
        assertThat(statusElementText, is("Password does not match the confirm password!"));
    }
}
