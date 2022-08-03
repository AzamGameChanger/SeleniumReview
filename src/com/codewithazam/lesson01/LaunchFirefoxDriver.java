package com.codewithazam.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchFirefoxDriver {
    public static void main(String[] args) throws InterruptedException {

        // WebDriver driver = new FirefoxDriver();
        // System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        String currentURL =  driver.getCurrentUrl();
        System.out.println("Current URL -> " + currentURL);

        String title =  driver.getTitle();
        System.out.println("Title -> " + title);

        driver.close(); // closes the current tab only
        // driver.quit(); // closes all the tabs/browsers

    }
}
