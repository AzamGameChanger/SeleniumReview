package com.codewithazam.review02;

import com.codewithazam.utils.Base;
import com.codewithazam.utils.ConfigsReader;
import org.openqa.selenium.By;

public class LoginOrangeHRM extends Base {
    public static void main(String[] args) throws InterruptedException {

        setUp();

        driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(ConfigsReader.getProperty("password"));

        driver.findElement(By.name("Submit")).submit();
//        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
//        System.out.println(welcomeMessage);

        Thread.sleep(3000);
        tearDown();

    }
}
