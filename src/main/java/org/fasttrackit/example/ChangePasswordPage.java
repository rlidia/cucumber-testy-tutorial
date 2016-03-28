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

    private WebLocator windowPreference=new WebLocator().setId("preferences-win");
    private TextField password=new TextField(windowPreference).setName("password");
    //in loc de setXpath avem setElPath - setElPath cand iti sti xpathul si dorim sa folosim xpathul

/*    @FindBy(how = How.XPATH, using ="//div[@id='preferences-win']//input[@name='password']")
    private  WebElement currentPasswField;*/
    private TextField currentPasswField=new TextField(windowPreference).setName("password");


 /*   @FindBy(how = How.XPATH, using ="//input[@name='newPassword']")
    private WebElement newPasswField;*/
    private TextField newPasswField=new TextField(windowPreference).setName("newPassword");

   /* @FindBy(how = How.XPATH, using ="//input[@name='newPasswordRepeat']")
    private  WebElement newPasswRepeatField;*/
   private TextField newPasswRepeatField=new TextField().setName("newPasswordRepeat");

   /* @FindBy(how = How.CSS, using="#preferences-win button.btn-warning")
    private WebElement saveButton;*/
   // private Button saveButton=new Button(windowPreference).setClasses("btn-warning");
    private Button saveButton=new Button(windowPreference).setText("Save");


  /*  @FindBy(how = How.CSS, using="#preferences-win .status-msg")
    private   WebElement statusMsj;*/
    private WebLocator statusMsj=new WebLocator(windowPreference).setClasses("status-msg");


    /*@FindBy(how = How.XPATH, using="/*//*[@id='preferences-win']//button[text()='Close']")
    private   WebElement btnClose;*/
    private Button btnClose=new Button(windowPreference).setText("Close");

    public void changePassword(String oldPassword, String newPassword) {
        currentPasswField.sendKeys(oldPassword);
        newPasswField.sendKeys(newPassword);
        Utils.sleep(300);
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