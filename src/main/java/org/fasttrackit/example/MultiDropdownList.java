package org.fasttrackit.example;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;

/**
 * Created by lidiar on 4/4/2016.
 */
public class MultiDropdownList extends DropdownList  {


    public boolean multiSelect(String... options) {
      //  assertClick();
        WebLocator selectEl1 = new WebLocator().setClasses("btn-group", "open");
        for(String option: options) {
            WebLocator elem1 = new WebLocator(selectEl1).withText(option, SearchType.CHILD_NODE);
            elem1.assertClick();
        }
        WebLocator shadow = new WebLocator().setClasses("dropdown-backdrop");
        shadow.assertClick();
        return true;
    }
}
