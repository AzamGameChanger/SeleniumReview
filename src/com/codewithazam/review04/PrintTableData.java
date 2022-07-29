package com.codewithazam.review04;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PrintTableData extends CommonMethods {
    public static void main(String[] args) {

        setUp();

        int colSize = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr[1]/td")).size();
        int rowSize = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr")).size();


        for (int row = 1; row <= rowSize; row++) {
            for (int col = 1; col < colSize; col++) {
                String path = "//table[@id='table2']/tbody/tr[" + row + "]/td[" + col + "]";
                WebElement element = driver.findElement(By.xpath("//table[@id='table2']/tbody/tr[" + row + "]/td[" + col + "]"));
                System.out.println(path  + " -> " + element.getText());
            }
        }
        tearDown();
    }
}
