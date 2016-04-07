package org.fasttrackit.example;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBarPage {
  /*  @FindBy(how = How.XPATH, using = "//nav//button")
    private WebElement preferencesButton;*/
    private Button preferencesButton=new Button().setElPath("//nav//button");

    private WebLink appDemoLink =new WebLink().setText("App Demo");
    public WebLink extJSDemo =new WebLink().setText("ExtJs Demo", SearchType.TRIM);



    public void openPreferencesWindow() {
        preferencesButton.click();

        // because of window animation (slide down)
        Utils.sleep(300);
    }


}