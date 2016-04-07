package org.fasttrackit.onlinelibrary.main;


import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.example.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

public class ExtJsDemoTest extends TestBase {
    private NavigationBarPage navBar = new NavigationBarPage();


    private void openPage() {
        driver.get("file:///D:/Selenium%20training/Testy/src/test/functional/app-demo/bootstrap/index.html");
    }

    @Test
    public void validLoginTest() {
        openPage();
        navBar.extJSDemo.click();



    }
}
