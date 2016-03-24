package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.LoginPage;
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
public class FirstLoginTest extends TestBase {

    private LoginPage loginPage;

    //right click -> Generate -> Constructor
    public FirstLoginTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void validLoginTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        Utils.sleep(2000);
        try {
            WebElement logOutLink = driver.findElement(By.linkText("Logout"));
            logOutLink.click();
        } catch (NoSuchElementException ex) {
            Assert.fail("could not login and find logout button");
        }
    }



    private void openUrl() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


    @Test
    public void failedLoginTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.passERROR");
        loginPage.assertThatErrorIs("Please enter your password!");

    }



    @Test
    public void withoutPasswordLoginTest() {
        openUrl();
        loginPage.doLogin("eu@fast.com", "");
        loginPage.assertThatErrorIs("Please enter your password!");

    }


    @Test
    public void withoutEmailLoginTest() {
        openUrl();
        loginPage.doLogin("", "eu@fast.com");

        loginPage.assertThatErrorIs("Please enter your email!");

    }

    @Test
    public void T4NoCredentialsLoginTest() {
        openUrl();
        loginPage.doLogin("", "");
        loginPage.assertThatErrorIs("Please enter your email!");

    }

    @Test
    public void T3successLoginTest() {
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


