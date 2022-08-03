package com.codewithazam.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.selenium.dev/");
        Thread.sleep(1000);
        driver.navigate().to("https://www.amazon.com/");

        for (int i = 0; i < 10; i++) {
            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().forward();
            Thread.sleep(1000);
        }

        driver.close();

    }
}
