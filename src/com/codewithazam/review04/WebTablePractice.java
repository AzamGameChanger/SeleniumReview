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
        System.out.println("Size of columns -> " + columns.size());

        List<WebElement> cells = driver.findElements(By.xpath("//tbody/tr/td"));
        System.out.println("Number of cells -> " + cells.size());

        // 1st wat, static way
        for (WebElement el : columns) {
            System.out.print(el.getText() + "; ");
        }

        System.out.println();
        // 2nd way, dynamic way, getting the first column data
        for (int i = 1; i <= columns.size(); i++) {
            WebElement cell = driver.findElement(By.xpath("//table/tbody/tr[1]/td[" + i + "]"));
            System.out.print(cell.getText() + ", ");
        }

        System.out.println();
        // dynamic way, getting data from the first row
        System.out.println();
        for (int i = 1; i <= rows.size(); i++) {
            WebElement dataFirstRow = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));
            System.out.print(dataFirstRow.getText() + "; ");
        }

        System.out.println();
        // dynamic way of printing every cell
        for (int row = 1; row <= rows.size(); row++) { // iterating the rows
            for (int col = 1; col <= columns.size(); col++) { // iterating the columns
                String path = "//table/tbody/tr[" + row + "]/td[" + col + "]";
                WebElement element = driver.findElement(By.xpath(path));
                System.out.println(path + " -> " + element.getText());
            }
        }

        tearDown();

    }
}
