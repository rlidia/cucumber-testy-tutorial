package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
// to remove unused imports meniu Code -Optimize imports
@Test
public class FirstLoginTest extends TestBase {

    private LoginView loginPage = new LoginView();

//ctrl+q see documentation to a method

    @Test
    public void validLoginTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        Utils.sleep(2000);
        WebLink logoutLink = new WebLink().setText("Logout");
        logoutLink.assertClick();

    }

    @Test(dataProvider = "invalidLogin")
    public void invalidLoginTest(String email,String password, String messageResult) {
        System.out.println("run this invalid test"+email+" - "+password+" - "+ messageResult);

        openUrl();
        loginPage.doLogin(email, password);
        loginPage.assertThatErrorIs(messageResult);
    }

    private void openUrl() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }

    @DataProvider
    public static Object[][] invalidLogin() {

        return new Object[][]{
                {"eu@fast.com", "eu.passERROR", "Invalid user or password!"},
                {"eu@fast.com", "", "Please enter your password!"},
                {"", "eu@fast.com", "Please enter your email!"},
                {"", "", "Please enter your email!"}
        };
    }



    @Test
    public void successLoginTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");
        Utils.sleep(2000);
        WebElement logOutLink = driver.findElement(By.linkText("Logoutx"));
        if (logOutLink.isDisplayed())

        {
            System.out.println("Element is Visible");
        } else

        {
            System.out.println("Element is InVisible");
        }
    }
}


