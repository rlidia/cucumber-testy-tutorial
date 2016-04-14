package org.fasttrackit.onlinelibrary.main;

import com.sdl.selenium.bootstrap.button.Button;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.utils.PropertiesReader;
import org.fasttrackit.example.AppDemoView;
import org.fasttrackit.example.FormTableView;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppDemoTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppDemoTest.class);

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
        String defaultSelectedOption= appDemo.selectP.getValue();
        Assert.assertEquals(defaultSelectedOption,"Auto");

        appDemo.selectP.select("No ADB");
        appDemo.selectP.select("Manual");
        String selectedOption= appDemo.selectP.getValue();
        Assert.assertEquals(selectedOption,"Manual");
    }


    @Test
    public void selectFromDropdownListTest() {
        openPage();
       // System.out.println(">"+appDemo.dropdownList.getValue()+"<");
        appDemo.dropdownList.select("Manual");
       // System.out.println(">"+appDemo.dropdownList.getValue()+"<");
        appDemo.executeL.select("No");


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
        String dirPath = "D:\\Selenium training\\demo_site\\";
        String resourcePath=PropertiesReader.RESOURCES_DIRECTORY_PATH;
      //  appDemo.selectFile.upload(selectFile,  resourcePath + "README.md");
        appDemo.selectFile.upload(selectFile,  dirPath + "README.md");
    }

    @Test
    public void selectFromMultiDropdownListTest() {
        openPage();
        // System.out.println(">"+appDemo.dropdownList.getValue()+"<");
        appDemo.multiselectL.multiSelect("Tomatoes","Mushrooms");
    }

    @Test
    public void multiSelectTest() {
        openPage();
        appDemo.multiSelect.select("Carrots","Tomatoes","Mushrooms","Pepperoni");
    }

    @Test
    public void selectAllTest() {
        openPage();
        boolean select=appDemo.multiSelect.select("Select all");
        Assert.assertTrue(select,"Cannot select all options");
    }


    @Test
    public void multiSelectSearchTest() {
        openPage();
        appDemo.multiselectL.assertClick();
        appDemo.searchFilter.sendKeys("M");
        appDemo.multiselectL.multiSelect("Mozzarella","Mushrooms");
    }


    @Test
    public void searchAfterAndMultiSelectTest(){
        openPage();
        appDemo.multiselectL.assertClick();
        appDemo.searchFilter.sendKeys("M");
        appDemo.multiselectL.multiSelect("Mozzarella","Pepperoni","Mushrooms");
        //nu ar fi bine sa punem in loc de assetClick doar click, daca nu gaseste Pepperoni sa treaca la urmatorul?
    }

    @Test
    public void tableTest(){
        openPage();
        //formTableView.clickOnCheckBoxRowWithName("John3",1);
        formTableView.clickOnCheckBoxRowWithName("John", 1);
        Row row = formTableView.table.getRow(new Cell(2, "John"), new Cell(3, "Rambo"));
        Row row1 = formTableView.table.getRow(new Cell(2, "John3"), new Cell(3, "Rambo3"),new Cell(4, "johnrambo@mail.com"));
        CheckBox c =  new CheckBox(row);
        Button b =  new Button(row1).setText("Second");
        c.click();
        b.click();
    }

    }
