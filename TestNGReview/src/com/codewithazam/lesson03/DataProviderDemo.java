package com.codewithazam.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigsReader;

public class DataProviderDemo extends CommonMethods {

    @BeforeMethod
    public void openAndNavigate() {
        setUp();
    }

    @AfterMethod
    public void quitBrowser() {
        tearDown();
    }

    @Test(dataProvider = "userData")
    public void loginFunctionality(String user, String pass){
        sendText(driver.findElement(By.id("txtUsername")), user);
        sendText(driver.findElement(By.id("txtPassword")), pass);
        click(driver.findElement(By.id("btnLogin")));

    }

    @DataProvider(name = "userData")
    public Object[][] getData(){
        Object[][] data = {
                {"Admin","admin123"},
                {"Flori","flori123"},
                {"Komron","komron123"}};

        return data;
    }
}
