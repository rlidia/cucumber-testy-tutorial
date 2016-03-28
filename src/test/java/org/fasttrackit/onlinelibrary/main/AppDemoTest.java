package org.fasttrackit.onlinelibrary.main;

import org.fasttrackit.example.AppDemoView;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.example.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;


public class AppDemoTest  extends TestBase {
    private AppDemoView appDemo =new AppDemoView();
    private LoginView loginPage=new LoginView();
    private NavigationBarPage navigationBarPage = new NavigationBarPage();

    private void openUrl() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }

    @Test
    public void pickDateCalendarTest(){
        openUrl();
        loginPage.doLogin("eu@fast.com", "eu.pass");
       // appDemo.selectCalendar.click();
        appDemo.dateP.select("25/03/2016");
    }
}
