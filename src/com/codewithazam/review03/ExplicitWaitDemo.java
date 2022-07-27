package com.codewithazam.review03;

import com.codewithazam.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo extends Base {
    public static void main(String[] args) throws InterruptedException {

        setUp();

        WebElement startDownload = driver.findElement(By.xpath("//button[@id='downloadButton']"));
        startDownload.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Complete!')]")));

        WebElement statusComplete =  driver.findElement(By.xpath("//div[contains(text(),'Complete!')]"));
        System.out.println(statusComplete.getText());

        Thread.sleep(2000);
        tearDown();
    }
}
