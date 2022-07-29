package com.codewithazam.review04;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablePractice extends CommonMethods {
    public static void main(String[] args) {
        setUp();

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Size of rows -> " + rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        System.out.println("Size of columns -> " +columns.size());


        tearDown();

    }
}
