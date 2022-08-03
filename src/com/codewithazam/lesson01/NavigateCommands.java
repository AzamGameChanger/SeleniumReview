package com.codewithazam.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommands {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        // driver.get("https://www.signal-telecom.net/store/");
        // will wait for the elements to be loaded

        driver.navigate().to("https://www.signal-telecom.net/store/");
        // will NOT wait for the elements to be loaded
        // will keep the history
        Thread.sleep(1000);

        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(1000);

        driver.navigate().back();
        // will go back to the previous page

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.manage().window().minimize();
        Thread.sleep(1000);

        Thread.sleep(2000);
        driver.close();
    }
}
