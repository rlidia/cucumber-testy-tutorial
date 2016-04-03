package org.fasttrackit.example;


import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.table.Table;


public class FormTableView extends WebLocator {

    public Table table=new Table(this);
    private CheckBox checkBoxTableRow = new  CheckBox();


    public FormTableView() {
        WebLocator formTable=new WebLocator().setTag("legend").setText("Form Table");
        setTag("form").setChildNodes(formTable);
    }

    public static void main(String[] args) {
        FormTableView formTable = new FormTableView().setTag("form");
        System.out.println(formTable.getSelector());
    }

    public void clickOnCheckBoxRowWithName(String firstName , int col){
        table.checkboxColumnSelect(firstName,col);
    }
}