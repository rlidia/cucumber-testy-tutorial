package org.fasttrackit.example;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.ICombo;


public class DropdownList extends WebLocator implements ICombo {

    public DropdownList() {
        setTag("button");
        setBaseCls("dropdown-toggle");
    }

    @Override
    public boolean select(String option) {
        assertClick();
        WebLocator selectEl1 = new WebLocator().setClasses("bootstrap-select", "open");
        WebLocator elem1 = new WebLocator(selectEl1).withText(option,  SearchType.CHILD_NODE);
        elem1.assertClick();
        return true;
}

    @Override
    public String getValue() {
        return getText().trim();
    }
}
