package com.codewithazam.review03;

import com.codewithazam.utils.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingAlerts extends Base {
    public static void main(String[] args) throws InterruptedException {

        setUp();

        WebElement alertButton =  driver.findElement(By.id("alert"));
        alertButton.click();

        // Handling the first alert
        Alert alert = driver.switchTo().alert();
        System.out.println("1 -> " + alert.getText());
        alert.accept();

        // Handling timing alert
        driver.findElement(By.id("timingAlert")).click();

        // this type of waiting is not good, because I don't want to wait too long
        // Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for a maximum of 30 seconds
        wait.until(ExpectedConditions.alertIsPresent());
        // If alert is present in 5 seconds, we wait only 5 seconds

        alert = driver.switchTo().alert();
        Thread.sleep(1000);
        System.out.println("2 -> " +alert.getText());
        Thread.sleep(1000);
        alert.accept();


        tearDown();
    }
}
