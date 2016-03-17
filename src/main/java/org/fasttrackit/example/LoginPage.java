package org.fasttrackit.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginPage {

    @FindBy(how=How.ID,using="email")
    private WebElement emailField;

    @FindBy(how=How.ID,using="password")
    private WebElement passwordField;

    @FindBy(how=How.CLASS_NAME,using="login-btn")
    private WebElement loginBtn;

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
        enterEmail(userName);
        enterPassword(passWord);
        clickLogin();

    }

}
