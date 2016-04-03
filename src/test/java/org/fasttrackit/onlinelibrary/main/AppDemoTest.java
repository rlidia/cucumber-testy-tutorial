package org.fasttrackit.onlinelibrary.main;

import com.sdl.selenium.bootstrap.button.Button;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import org.fasttrackit.example.AppDemoView;
import org.fasttrackit.example.FormTableView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;


public class AppDemoTest extends TestBase {
    private AppDemoView appDemo = new AppDemoView();
    private FormTableView formTableView =new FormTableView();
    private void openPage() {
        driver.get("file:///D:/Selenium%20training/Testy/src/test/functional/app-demo/bootstrap/index.html");
    }

    @Test
    public void pickDateCalendarTest() {
        openPage();
        appDemo.selectCalendar.click();
        appDemo.dateP.select("25/03/2016");
    }

    @Test
    public void selectFromDropdownTest() {
        openPage();
        appDemo.selectP.select("No ADB");
    }

    @Test
    public void selectCheckBoxesTest(){
        openPage();
        appDemo.checkBoxStopProc.click();
        appDemo.checkBoxLabelEnter.click();
        appDemo.checkBoxStopProc.click();
    }


    @Test
    public void uploadFileTest(){
        openPage();
        UploadFile selectFile = new UploadFile(appDemo, "TPT Test:");
        String exePath = "D:\\Selenium training\\cucumber-testy-tutorial\\src\\test\\resources\\upload\\upload.exe";
        String dirPath = "D:\\Selenium training\\demo_site\\style.css";
        appDemo.selectFile.upload(selectFile, new String[]{exePath, dirPath + "README.md"});
        appDemo.selectFile.change("Change", new String[]{exePath, dirPath + "style.css"});
    }

    @Test
    public void tableTest(){
        openPage();
        //formTableView.clickOnCheckBoxRowWithName("John3",1);
        formTableView.clickOnCheckBoxRowWithName("John", 1);
        Row row = formTableView.table.getRow(new Cell(2, "John"), new Cell(3, "Rambo"));
        CheckBox c =  new CheckBox(row);
        Button b =  new Button(row);
        c.click();

    }
}
