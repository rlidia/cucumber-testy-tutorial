package org.fasttrackit.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPage {

    @FindBy(how=How.ID,using="email")
    private WebElement emailField;

    @FindBy(how=How.NAME,using="password")
    private WebElement passwordField;

    @FindBy(how=How.CLASS_NAME,using="login-btn")
    private WebElement loginBtn;

    @FindBy(how=How.CLASS_NAME,using="error-msg")
    private WebElement warningMsj;

    public void enterEmail(String email){
        System.out.println("Email :"+email);
        emailField.sendKeys(email);
    }

    public void enterPassword(String passw){
        passwordField.sendKeys(passw);
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public void doLogin(String userName, String passWord) {
        emailField.sendKeys(userName);
        passwordField.sendKeys(passWord);
        loginBtn.click();

    }

    public  void assertThatErrorIs(String message) {
        System.out.println(warningMsj.getText());
        assertThat(warningMsj.getText(), is(message));
    }
}
