package com.codewithazam.review04;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarHandling extends CommonMethods {
    public static void main(String[] args) {

        setUp();
        WebElement frame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
        switchToFrame(frame);

        click(driver.findElement(By.id("datepicker")));
        String expectedMonthYear = "December 2022";

        while (true) {
            WebElement monthYear = driver.findElement(By.cssSelector("[class='ui-datepicker-title']"));
            if (monthYear.getText().equalsIgnoreCase(expectedMonthYear)){
                break;
            }
            click(driver.findElement(By.xpath("//span[contains(text(),'Next')]")));
        }

        String expectedDate = "12";
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement date:dates){
            if (date.getText().equals(expectedDate)){
                click(date);
                break;
            }
        }

        wait(2);

        tearDown();
    }
}
