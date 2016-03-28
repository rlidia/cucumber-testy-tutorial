package org.fasttrackit.example;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordPage {

    private WebLocator windowPreference=new WebLocator().setId("preferences-win").setClasses("in");
    private TextField password=new TextField(windowPreference).setName("password");

    private TextField currentPasswField=new TextField(windowPreference).setName("password");

    private TextField newPasswField=new TextField(windowPreference).setName("newPassword");

    private TextField newPasswRepeatField=new TextField().setName("newPasswordRepeat");

    private Button saveButton=new Button(windowPreference).setText("Save");

    private WebLocator statusMsj=new WebLocator(windowPreference).setClasses("status-msg");

    private Button btnClose=new Button(windowPreference).setText("Close");

    public void changePassword(String oldPassword, String newPassword) {
        currentPasswField.sendKeys(oldPassword);
        newPasswField.sendKeys(newPassword);
        newPasswRepeatField.sendKeys(newPassword);
        saveButton.click();

    }



    public void changePassword3Param(String oldPassword, String newPassword, String repeatPassword) {
        currentPasswField.sendKeys(oldPassword);
        newPasswField.sendKeys(newPassword);

        newPasswRepeatField.sendKeys(repeatPassword);
        saveButton.click();
    }

    public  void assertThatErrorIs(String message) {
        assertThat(statusMsj.getHtmlText(), is(message));
    }

    public void closePreferenceWindows(){
        btnClose.click();
    }
}