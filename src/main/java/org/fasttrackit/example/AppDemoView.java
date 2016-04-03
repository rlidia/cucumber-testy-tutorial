package org.fasttrackit.example;



import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.SelectFilesHandler;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.table.Table;


/**
 * Created by lidiar on 3/28/2016.
 */
public class AppDemoView extends WebLocator {


    ;
    public WebLocator selectCalendar =new WebLocator(this).setClasses("icon-calendar");
   // private WebLocator dateCalendar = new ;
    public DatePicker dateP=new DatePicker(this);
    public SelectPicker selectP =new SelectPicker(this);
    public CheckBox checkBoxStopProc =  new CheckBox(this).setLabel("Stop the process?", SearchType.CHILD_NODE).setLabelPosition("//");
    public CheckBox checkBoxLabelEnter =  new CheckBox(this).setLabel("Label with Enter.", SearchType.CHILD_NODE).setLabelPosition("//");

    public UploadFile selectFile = new UploadFile(this, "TPT Test:");

    private WebLocator disabledFieldSpan = new WebLocator(this).setLabel("Span");





    public AppDemoView() {
        WebLocator formTitle=new WebLocator().setTag("legend").setText("Form Title");
        setTag("form").setChildNodes(formTitle);
    }



    public static void main(String[] args) {
         AppDemoView appDemo = new AppDemoView().setTag("form");
       // System.out.println(appDemo.getSelector());
        System.out.println(appDemo.selectFile.getSelector());
    }
}
