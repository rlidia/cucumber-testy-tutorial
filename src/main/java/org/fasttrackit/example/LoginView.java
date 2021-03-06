package org.fasttrackit.example;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginView {


    private TextField emailField = new TextField().setLabel("Email:");

    private TextField passwordField=new TextField().setName("password");

   //nu conteaza daca scriu WebLocator().setText("Login").setTag("button") sau WebLocator().setTag("button").setText("Login")
   //private WebLocator loginBtn=new WebLocator().setTag("button").setText("Login");
    private Button loginBtn=new Button().setText("Login");

    private WebLocator warningMsj=new WebLocator("error-msg");

    public static void main(String[] args) {
        LoginView loginView=new LoginView();
        System.out.println(loginView.emailField.getXPath());
        System.out.println(loginView.passwordField.getXPath());
        System.out.println(loginView.loginBtn.getXPath());
        System.out.println(loginView.warningMsj.getSelector());
    }

    public void doLogin(String userName, String passWord) {
        emailField.sendKeys(userName);
        passwordField.sendKeys(passWord);
        loginBtn.click();
    }

    public  void assertThatErrorIs(String message) {
        assertThat(warningMsj.getHtmlText(), is(message));
    }
}
