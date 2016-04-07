package org.fasttrackit.example;


import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;


public class AppDemoView extends WebLocator {


    ;
    public WebLocator selectCalendar = new WebLocator(this).setClasses("icon-calendar");
    // private WebLocator dateCalendar = new ;
    public DatePicker dateP = new DatePicker(this);
    public SelectPicker selectP = new SelectPicker(this).setLabel("Tech:");
    public DropdownList dropdownList = new DropdownList().setLabel("Tech:");
    public DropdownList executeL = new DropdownList().setLabel("Execute");

    public MultiDropdownList multiselectL = new MultiDropdownList().setLabel("Source:");
    public WebLocator searchFilter = new WebLocator().setTag("input").setClasses("multiselect-search");

    public CheckBox checkBoxStopProc = new CheckBox(this).setLabel("Stop the process?", SearchType.CHILD_NODE).setLabelPosition("//");
    public CheckBox checkBoxLabelEnter = new CheckBox(this).setLabel("Label with Enter.", SearchType.CHILD_NODE).setLabelPosition("//");

    public UploadFile selectFile = new UploadFile(this, "TPT Test:");

    private WebLocator disabledFieldSpan = new WebLocator(this).setLabel("Span");

    public WebLocator multiSelectContainer = new WebLocator(this).setLabel("Source:");
    public MultiSelect multiSelect = new MultiSelect(this, "Source:");


    public AppDemoView() {
        WebLocator formTitle = new WebLocator().setTag("legend").setText("Form Title");
        setTag("form").setChildNodes(formTitle);
    }


    public static void main(String[] args) {
        AppDemoView appDemo = new AppDemoView().setTag("form");
        // System.out.println(appDemo.getSelector());
        System.out.println(appDemo.selectFile.getSelector());
    }
}
