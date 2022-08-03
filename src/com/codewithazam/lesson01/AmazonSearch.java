package com.codewithazam.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.amazon.com/");

        // There are 8 locators to find the elements in the DOM
        // id, name, className, linkText, partialLinkText, tagName, xpath, cssSelector

        WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));
        searchText.sendKeys("clothes");

        WebElement searchButton =  driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

        Thread.sleep(2000);
        driver.close();
    }
}
