package com.codewithazam.review03;

import com.codewithazam.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class HandlingWindows extends Base {
    public static void main(String[] args) {
        setUp();

        String parentWindowId = driver.getWindowHandle(); // this will return the unique ID of the current page
        System.out.println(parentWindowId);
        System.out.println("===========================================");

        WebElement childWindow = driver.findElement(By.cssSelector("[title='seleniumframework']"));
        childWindow.click();

        Set<String> allWindowIDs = driver.getWindowHandles();
        Iterator<String> iterator = allWindowIDs.iterator();
        while (iterator.hasNext()){
            String windowID =  iterator.next();
            if (!windowID.equals(parentWindowId))
                driver.switchTo().window(windowID);
        }

//        String verifyPage = driver.findElement(By.xpath("//strong[contains(text(),'Agile Testing and ATDD Automation –  Free Tutorial')]")).getText();
//        System.out.println(verifyPage);


        tearDown();
    }
}
