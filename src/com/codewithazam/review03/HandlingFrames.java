package com.codewithazam.review03;

import com.codewithazam.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingFrames extends Base {
    public static void main(String[] args) throws InterruptedException {
        setUp();

        // 1st way, switching by index
        // driver.switchTo().frame(0);

        // 2nd way, switching by ID or by Name
        // driver.switchTo().frame("mce_0_ifr");

        // 3rd way, switching by WebElement
        WebElement frameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);

        driver.findElement(By.id("tinymce")).sendKeys("What's up cutie?");
        driver.switchTo().defaultContent();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        Thread.sleep(3000);

        tearDown();
    }
}
