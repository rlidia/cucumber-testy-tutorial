package org.fasttrackit.example;

import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.link.WebLink;

/**
 * Created by lidiar on 3/28/2016.
 */
public class AppDemoView extends WebLocator {


    public WebLocator selectCalendar =new WebLocator(this).setClasses("icon-calendar");
   // private WebLocator dateCalendar = new ;
    public DatePicker dateP=new DatePicker(this);

    public AppDemoView() {
        WebLocator formTitle=new WebLocator().setTag("legend").setText("Form Title");
        setTag("form").setChildNodes(formTitle);
    }


    public static void main(String[] args) {
         AppDemoView appDemo = new AppDemoView().setTag("form");
        System.out.println(appDemo.getSelector());
    }
}
