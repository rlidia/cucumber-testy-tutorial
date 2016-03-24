package org.fasttrackit.example;

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by lidiar on 3/17/2016.
 */
public class ChangePasswordPage {


    @FindBy(how = How.XPATH, using ="//div[@id='preferences-win']//input[@name='password']")
    private  WebElement currentPasswField;

    @FindBy(how = How.XPATH, using ="//input[@name='newPassword']")
    private WebElement newPasswField;

    @FindBy(how = How.XPATH, using ="//input[@name='newPasswordRepeat']")
    private  WebElement newPasswRepeatField;

    @FindBy(how = How.CSS, using="#preferences-win button.btn-warning")
    private WebElement saveButton;

    @FindBy(how = How.CSS, using="#preferences-win .status-msg")
    private   WebElement statusMsj;

    public void changePassword(String oldPassword, String newPassword) {
        currentPasswField.sendKeys(oldPassword);
        newPasswField.sendKeys(newPassword);
        newPasswRepeatField.sendKeys(newPassword);
        saveButton.click();

    }

    public String getStatusMessage(){
        return statusMsj.getText();
    }

    public void changePassword3Param(String oldPassword, String newPassword, String repeatPassword) {
        currentPasswField.sendKeys(oldPassword);
        newPasswField.sendKeys(newPassword);
        newPasswRepeatField.sendKeys(repeatPassword);
        saveButton.click();
    }
}