package org.fasttrackit.example;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage {

    private WebLocator windowPreference=new WebLocator().setId("preferences-win");
    TextField password=new TextField(windowPreference).setName("password");
    //in loc de setXpath avem setElPath - setElPath cand iti sti xpathul si dorim safolosim si  stim xpathul

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

    @FindBy(how = How.XPATH, using="//*[@id='preferences-win']//button[text()='Close']")
    private   WebElement btnClose;

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

    public void closePreferenceWindows(){
        btnClose.click();
    }
}