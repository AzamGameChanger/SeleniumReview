package com.codewithazam.review05;

import com.codewithazam.utils.CommonMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class UploadExample extends CommonMethods {
    public static void main(String[] args) {

        setUp();

        String filePath = System.getProperty("user.dir") + "/screenshots/hrm.png";
        sendText(driver.findElement(By.cssSelector("#image_file")), filePath);
        wait(1);

        click(driver.findElement(By.xpath("//input[@value='Upload']")));
        wait(5);

        String expectedText = "File Successfully Uploaded";
        waitForVisibility(driver.findElement(By.xpath("//div[@class='ContactUs']")));
        String actualText = driver.findElement(By.xpath("//p[contains(text(),'File Successfully Uploaded')]")).getText();

        String destPath = "screenshots";
        if (expectedText.equalsIgnoreCase(actualText)){
            //System.out.println("Success");
            destPath += "/passed/upload.png";
        }
        else {
            destPath += "/failed/upload.png";
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(destPath);
        try {
            FileUtils.copyFile(sourceFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tearDown();
    }
}
