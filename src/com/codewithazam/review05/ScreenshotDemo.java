package com.codewithazam.review05;

import com.codewithazam.utils.CommonMethods;
import com.codewithazam.utils.ConfigsReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ScreenshotDemo extends CommonMethods {
    public static void main(String[] args) {

        setUp();

        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
        click(driver.findElement(By.id("btnLogin")));

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        wait(1);

        // TakesScreenshot ts = (TakesScreenshot) driver;
        WebElement table = driver.findElement(By.id("resultTable"));
        TakesScreenshot ts = (TakesScreenshot) table;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots/table.png");
        try {
            FileUtils.copyFile(sourceFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        wait(2);
        tearDown();
    }
}
