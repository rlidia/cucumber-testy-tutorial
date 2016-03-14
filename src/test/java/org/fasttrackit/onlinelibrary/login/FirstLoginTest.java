package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class FirstLoginTest extends TestBase {


    @Test
    public void validLoginTest() {
        openUrl();
        doLogin("eu@fast.com", "eu.pass");

        Utils.sleep(2000);
        try {
            WebElement logOutLink = driver.findElement(By.linkText("Logout"));
            logOutLink.click();
        } catch (NoSuchElementException ex) {
            Assert.fail("could not login and find logout button");
        }
    }

    private void doLogin(String userName, String passWord) {
        //driver.findElement(By.id("email")).sendKeys("eu@fast.com");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(userName);
        WebElement passwField = driver.findElement(By.id("password"));
        passwField.sendKeys(passWord);

        //  WebElement loginBtn = driver.findElement(By.id("loginButton"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
    }

    private void openUrl() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


    @Test
    public void failedLoginTest() {
        openUrl();
        doLogin("eu@fast.com", "eu.passERROR");
        assertThatErrorIs("Please enter your password!");

    }

    private void assertThatErrorIs(String message) {
        WebElement warningMsj = driver.findElement(By.className("error-msg"));
        System.out.println(warningMsj.getText());
        assertThat(warningMsj.getText(), is(message));
    }

    @Test
    public void withoutPasswordLoginTest() {
        openUrl();
        doLogin("eu@fast.com", "");
        assertThatErrorIs("Please enter your password!");

    }


    @Test
    public void withoutEmailLoginTest() {
        openUrl();
        doLogin("", "eu@fast.com");

        assertThatErrorIs("Please enter your email!");

    }

    @Test
    public void T4NoCredentialsLoginTest() {
        openUrl();
        doLogin("", "");
        assertThatErrorIs("Please enter your email!");

    }

    @Test
    public void T3successLoginTest() {
        openUrl();
        doLogin("eu@fast.com", "eu.pass");

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

    @Test
    public void successChangePassword() {
        openUrl();
        doLogin("eu@fast.com", "eu.pass");

        WebElement preferenceButton = driver.findElement(By.xpath("//nav//button"));
        preferenceButton.click();

        Utils.sleep(2000);

       // WebElement currentPasswField = driver.findElement(By.cssSelector( "#preferences-win input[name=password]");
        WebElement currentPasswField = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='password']"));
        currentPasswField.sendKeys("eu.pass");


        WebElement newPasswField = driver.findElement(By.xpath("//input[@name='newPassword']"));
        newPasswField.sendKeys("eu.pass2");

        /*CTRL+D face copypaste la ce ai selectat*/

        WebElement newPasswRepeatField = driver.findElement(By.xpath("//input[@name='newPasswordRepeat']"));
        newPasswRepeatField.sendKeys("eu.pass2");

        //WebElement saveButton = driver.findElement(By.xpath("//div[@id='preferences-win']//button[text()='Save']"));
        WebElement saveButton = driver.findElement(By.cssSelector("#preferences-win button.btn-warning"));
        saveButton.click();

/*
        WebElement warningMsj = driver.findElement(By.className("status-msg"));
        assertThat(warningMsj.getText(), is("Password does not match the confirm password!"));
        */

        WebElement statusMsj = driver.findElement(By.cssSelector("#preferences-win .status-msg"));
        assertThat(statusMsj.getText(), is("Your password has been successfully changed."));
    }


}


