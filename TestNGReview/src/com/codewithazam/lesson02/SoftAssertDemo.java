package com.codewithazam.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.CommonMethods;
import utils.ConfigsReader;

public class SoftAssertDemo extends CommonMethods {

    @BeforeMethod
    public void openAndNavigate() {
        setUp();
    }

    @AfterMethod
    public void quitBrowser() {
        tearDown();
    }

    @Test
    public void logoAndWelcomeValidation(){
        WebElement logo = driver.findElement(By.id("divLogo"));
        boolean logoDisplayed = logo.isDisplayed();
        logoDisplayed = false;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(logoDisplayed,"Logo is not displayed.");


        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
        click(driver.findElement(By.id("btnLogin")));

        //String expectedMessage = "Welcome Paul";
        boolean welcomeMessage = driver.findElement(By.id("welcome")).isDisplayed();
        softAssert.assertTrue(welcomeMessage,"Welcome msg not displayed!");

        softAssert.assertAll();

        System.out.println("After assertAll");

    }
}
