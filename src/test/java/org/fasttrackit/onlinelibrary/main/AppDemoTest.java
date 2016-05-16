package org.fasttrackit.onlinelibrary.main;

import com.sdl.selenium.bootstrap.button.Button;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.utils.PropertiesReader;
import org.fasttrackit.example.AppDemoView;
import org.fasttrackit.example.FormTableView;
import org.fasttrackit.example.SenchaExampleView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


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

    @Test
    public void scrollToViewTest() {
        SenchaExampleView senchaExampleView = new SenchaExampleView();

        senchaExampleView.open();

        WebDriverConfig.switchToLastTab();

        WebLocator headerCt = new WebLocator().setClasses("x-grid-header-ct");
        WebLocator header = new WebLocator(headerCt).setText("Manufacturer");
        WebLocator header2 = new WebLocator(headerCt).setText("Title");
        //header2.findElement();

        header.click();

        (new Actions(driver)).dragAndDrop(header.currentElement, header2.currentElement).perform();
        //        (new Actions(WebDriverConfig.getDriver())).dragAndDropBy(header.currentElement, -280, -35).build().perform();
    }

    @Test
    public void scrollTest(){
        SenchaExampleView exampleView = new SenchaExampleView();
        exampleView.open("Miscellaneous", "Resizable");
        WebDriverConfig.switchToLastTab();

        WebLocator basicPanel = new WebLocator().setId("basic");
        WebLocator resizableEast = new WebLocator(basicPanel).setClasses("x-resizable-handle-east");
        resizableEast.mouseOver();
        (new Actions(WebDriverConfig.getDriver())).dragAndDropBy(resizableEast.currentElement, 300, 0).build().perform();
    }



    @Test
    public void getPhotoNameTest(){
        driver.get("http://examples.sencha.com/extjs/6.0.2/examples/classic/view/data-view.html");
       /*itar tab si se creaza for-ul*/
       /*fori tab si se creaza for-ul*/
        /* Versiunea Matei 3         */
        WebLocator wrap=new WebLocator().setId("dataview-example");
        WebLocator imgL= new WebLocator(wrap).setTag("img");
        /*imgL.waitToRender();
        sau*/
        imgL.ready();
        for (WebElement img:imgL.findElements()) {
            String titleI= img.getAttribute("title");
            LOGGER.debug(titleI);
        }

        /*versiunea Matei 1
        List<WebElement> imagesL = driver.findElements(By.cssSelector("#dataview-example img"));
        for (int i = 0; i <imagesL.size() ; i++) {
            String titleI= imagesL.get(i).getAttribute("title");
            LOGGER.debug(titleI);
        }
        */

           /*versiunea Matei 2
        List<WebElement> imagesL = driver.findElements(By.cssSelector("#dataview-example img"));
        for (WebElement img:imagesL) {
            String titleI= imagesL.getAttribute("title");
            LOGGER.debug(titleI);
        }
        */


        /* versiunea 1
           WebLocator images = new WebLocator().setTag("img");
        List<WebElement> el = images.findElements();
        for ( WebElement e : el ) {
           System.out.println(e.getAttribute("title"));
        } */
    }


    @Test
    public void clickOnCertainPhotoTest(){
        driver.get("http://examples.sencha.com/extjs/6.0.2/examples/classic/view/data-view.html");
       /*itar tab si se creaza for-ul*/
       /*fori tab si se creaza for-ul*/
        WebLocator dataview=new WebLocator().setId("dataview-example");
        WebLocator wrap=new WebLocator(dataview).setClasses("thumb-wrap");
        WebLocator imgL= new WebLocator(wrap).setTag("img");
        imgL.ready();
        wrap.setPosition(3);
        LOGGER.debug(imgL.getSelector().toString());
        wrap.click();
    }

}
