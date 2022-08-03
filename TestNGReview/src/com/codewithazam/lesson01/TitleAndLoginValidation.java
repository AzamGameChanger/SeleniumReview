package com.codewithazam.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigsReader;

public class TitleAndLoginValidation extends CommonMethods {

    @BeforeMethod
    public void openAndNavigate() {
        setUp();
    }

    @AfterMethod
    public void quitBrowser() {
        tearDown();
    }

    @Test
    public void titleValidation() throws Exception {
        String expectedTitle = "OrangeHRM";
        String title = driver.getTitle();

        if (expectedTitle.equals(title))
            System.out.println("Success");
        else {
            System.out.println("Failure");
            throw new Exception();
        }
    }

    @Test
    public void logoValidation() throws Exception {
        WebElement logo = driver.findElement(By.id("divLogo"));
        boolean isDisplayed = logo.isDisplayed();

        if (isDisplayed)
            System.out.println("Passed");
        else {
            System.out.println("Failed");
            throw new Exception();
        }
    }

    @Test
    public void loginValidation() throws Exception {
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
        click(driver.findElement(By.id("btnLogin")));

        String expectedMessage = "Welcome";
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();

        if (welcomeMessage.contains(expectedMessage))
            System.out.println("Verified");
        else {
            System.out.println("Not verified.");
            throw new Exception();
        }
    }

}
