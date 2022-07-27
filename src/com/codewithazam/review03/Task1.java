package com.codewithazam.review03;

import com.codewithazam.utils.Base;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class Task1 extends Base {
    public static void main(String[] args) throws InterruptedException {
        setUp();

        driver.findElement(By.cssSelector("[title='seleniumframework']")).click();

        Set<String> allHandles = driver.getWindowHandles();
        Iterator<String> iterator = allHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        for (int i = 1; i <= 5; i++) {
            driver.switchTo().window(parentWindow);
            Thread.sleep(1000);
            driver.switchTo().window(childWindow);
        }

        tearDown();
    }
}
