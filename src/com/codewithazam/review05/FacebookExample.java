package com.codewithazam.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FacebookExample {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("debugtester3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Debugger3!");
        driver.findElement(By.name("login")).submit();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Tester Debug']")).click();

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(3000);
        }

        Thread.sleep(2000);
        driver.quit();


    }
}
