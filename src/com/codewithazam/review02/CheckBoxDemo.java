package com.codewithazam.review02;

import com.codewithazam.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxDemo extends Base {
    public static void main(String[] args) throws InterruptedException {

        setUp();

        List<WebElement> radioList = driver.findElements(By.cssSelector("[name='optradio']"));
        radioList.get(1).click();
        Thread.sleep(2000);

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < checkBoxList.size(); i++) {
            checkBoxList.get(i).click();
            if (checkBoxList.get(i).isSelected())
                System.out.println("It is selected");
            else
                System.out.println("It is not selected");


            Thread.sleep(2000);
        }
        
        tearDown();
    }
}
