package com.codewithazam.review01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement fullName =  driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Azim Kalamov");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("azim@gmail.com");

        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys("Hello World!");
        driver.findElement(By.cssSelector("[id='permanentAddress']")).sendKeys("Joe Biden.");

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#submit")).submit(); // if you are inside the form use submit (recommended)


        Thread.sleep(5000);
        driver.quit();

    }
}
