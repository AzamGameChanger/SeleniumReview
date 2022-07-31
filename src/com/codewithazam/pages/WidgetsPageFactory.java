package com.codewithazam.pages;

import com.codewithazam.utils.Base;
import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPageFactory{

    public WidgetsPageFactory(){
        PageFactory.initElements(Base.driver,this);
    }

    @FindBy(id = "image_file")
    public WebElement chooseFile;

    @FindBy(css = "input[value='Upload']")
    public WebElement upload;
}
