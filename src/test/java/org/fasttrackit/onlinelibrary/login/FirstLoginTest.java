package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lidiar on 3/7/2016.
 */
@Test
public class FirstLoginTest extends TestBase {


    @Test
    public void T1validLoginTest() {
        openUrl();
        doLogin("eu@fast.com","eu.pass");

        Utils.sleep(2000);
        try {
            WebElement logOutLink = driver.findElement(By.linkText("Logout"));
            logOutLink.click();
        } catch (NoSuchElementException ex) {
            Assert.fail("could not logn and find logout button");
        }
    }

    private void doLogin(String userName, String passWord) {
        //driver.findElement(By.id("email")).sendKeys("eu@fast.com");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(userName);
        WebElement passwField = driver.findElement(By.id("password"));
        passwField.sendKeys(passWord);

        //  WebElement loginBtn = driver.findElement(By.id("loginButton"));
        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();
    }

    private void openUrl() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


    @Test
    public void T2failedLoginTest() {
        openUrl();
        doLogin("eu@fast.com","eu.passERROR");
    }

    @Test
    public void T4NoCredentialsLoginTest() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

        Utils.sleep(2000);
        WebElement warningMsj=driver.findElement(By.className("error-msg"));

        if (warningMsj.isDisplayed())

        {
            System.out.println("Message is displayed");
        } else

        {
            System.out.println("Message is not displayed");
        }
    }

    @Test
    public void T3successLoginTest() {
        openUrl();
        doLogin("eu@fast.com","eu.pass");

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


