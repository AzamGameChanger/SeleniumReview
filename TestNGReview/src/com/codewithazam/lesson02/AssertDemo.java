package com.codewithazam.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class AssertDemo extends CommonMethods {

    @BeforeMethod
    public void openAndNavigate() {
        setUp();
    }

    @AfterMethod
    public void quitBrowser() {
        tearDown();
    }

    @Test(enabled = false)
    public void titleValidation() {
        String expectedTitle = "OrangeHRM";
        String title = driver.getTitle();

        // 1st way
        // Assert.assertEquals(title,expectedTitle);

        // 2nd way, you are giving the meaningful message
        Assert.assertEquals(title, expectedTitle, "Title doesn't match");

        // if (hard) assertion fails
        // the code after assertion will not be executed
        System.out.println("Text after assertion");
    }

    @Test(enabled = true)
    public void logoValidation() {
        WebElement logo = driver.findElement(By.id("divLogo"));
        boolean logoDisplayed = logo.isDisplayed();
        // logoDisplayed = false;

        // 1st way
        // Assert.assertEquals(logoDisplayed,true);

        // 2nd way
        // Assert.assertEquals(logoDisplayed, true, "Logo is not displayed.");

        // 3rd way
        Assert.assertTrue(logoDisplayed, "Logo is not displayed");
    }
}
