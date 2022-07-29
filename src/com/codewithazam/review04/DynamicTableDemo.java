package com.codewithazam.review04;

import com.codewithazam.utils.CommonMethods;
import com.codewithazam.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicTableDemo extends CommonMethods {
    public static void main(String[] args) {
        setUp();

        sendText(driver.findElement(By.id("ctl00_MainContent_username")), ConfigsReader.getProperty("login"));
        sendText(driver.findElement(By.id("ctl00_MainContent_password")), ConfigsReader.getProperty("pass"));
        click(driver.findElement(By.id("ctl00_MainContent_login_button")));

        wait(1);

        int rowSize = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr")).size();
        for (int i = 2; i <= rowSize; i++) {
            WebElement element = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + i + "]"));
            String rowText = element.getText();
            if (rowText.contains("FamilyAlbum")) {
                WebElement firstCol = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + i + "]/td[1]"));
                firstCol.click();
            }
        }

        click(driver.findElement(By.id("ctl00_MainContent_btnDelete")));

        wait(2);
        tearDown();
    }
}
