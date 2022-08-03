package com.codewithazam.review05;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropDemo extends CommonMethods {
    public static void main(String[] args) {
        setUp();

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));


        Actions a = new Actions(driver);
        // a.dragAndDrop(drag, drop).perform();

        //a.clickAndHold(drag).moveToElement(drop).release().perform();

        WebElement two = driver.findElement(By.cssSelector("[name='two']"));
        WebElement seven =  driver.findElement(By.cssSelector("[name='seven']"));
        WebElement eleven = driver.findElement(By.cssSelector("[name='eleven']"));

        a.clickAndHold(two).moveToElement(seven).moveToElement(eleven).release().perform();
        wait(1);




        tearDown();
    }
}
