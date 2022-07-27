package com.codewithazam.review03;

import com.codewithazam.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownDemo extends Base {
    public static void main(String[] args) throws InterruptedException {

        setUp();

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        // we can select dropdown in 3 different ways
        // ByIndex(); ByVisibleText(); ByValue();

        select.selectByValue("1");
        // select.selectByIndex(2);
        // select.selectByVisibleText("Option 1");

        List<WebElement> options = select.getOptions();
        System.out.println(options.size());
        for (WebElement option:options){
            System.out.println(option.getText());
        }

        Thread.sleep(3000);
        tearDown();
    }
}
