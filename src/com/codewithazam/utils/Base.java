package com.codewithazam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Base {

    public static WebDriver driver;

    public static WebDriver setUp(){
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.getProperty("browser").toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        driver.manage().window().maximize();

        driver.get(ConfigsReader.getProperty("url"));

        return driver;
    }

    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
