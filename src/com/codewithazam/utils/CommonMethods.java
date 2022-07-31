package com.codewithazam.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class CommonMethods extends Base {

    /**
     * This method clears a textbox and send the new text to it.
     *
     * @param element
     * @param text
     */
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method clicks to the specific element
     *
     * @param element
     */
    public static void click(WebElement element){
        element.click();
    }

    /**
     * This method checks if radio/checkbox is enabled and then clicks on the
     * element that has the value we want.
     *
     * @param listElement
     * @param value
     */
    public static void clickRadioOrCheckbox(List<WebElement> listElement, String value) {
        String actualValue;

        for (WebElement el : listElement) {
            actualValue = el.getAttribute("value").trim();
            if (el.isEnabled() && actualValue.equals(value)) {
                el.click();
                break;
            }
        }
    }

    /**
     * This method puts the thread to sleep and handles the exception for us.
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will check if a desired text is found in the dropdown and only
     * then select it.
     *
     * @param element
     * @param textToSelect
     */
    public static void selectDropdown(WebElement element, String textToSelect) {
        try {
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();

            for (WebElement el : options) {
                if (el.getText().equals(textToSelect)) {
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will check if an index exists in the dropdown and only then select it.
     *
     * @param element
     * @param index
     */
    public static void selectDropdown(WebElement element, int index) {
        try {
            Select select = new Select(element);
            int size = select.getOptions().size();

            if (size > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method accepts the alert and will catch the exception if no alert is present.
     */
    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will dismiss the alert and will catch the exception if no alert is present.
     */
    public static void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the text of the alert. If no alert is present, the exception
     * will be caught and a null will be returned.
     *
     * @return
     */
    public static String getAlertText() {
        String text = null;

        try {
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        return text;
    }

    /**
     * This method will send a text to the alert. If no alert is present then it
     * will catch the exception.
     *
     * @param text
     */
    public static void sendTextToAlert(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will switch to a frame using name or id. It will also
     * handle the NoSuchFrameException
     *
     * @param nameOrId
     */
    public static void switchToFrame(String nameOrId){
        try {
            driver.switchTo().frame(nameOrId);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * This method will switch to a frame using an index. It will also handle the NoSuchFrameException.
     *
     * @param index
     */
    public static void switchToFrame(int index){
        try {
            driver.switchTo().frame(index);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * This method will switch to a frame using a web element. It will also handle
     * the NoSuchFrameException
     *
     * @param element
     */
    public static void switchToFrame(WebElement element){
        try {
            driver.switchTo().frame(element);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * This method creates a WebDriverWait object and returns it.
     *
     * @return
     */
    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

        return wait;
    }

    /**
     * This method will implement an explicit wait on an element.
     *
     * @param element
     * @return
     */
    public static WebElement waitForClickAbility(WebElement element){

        return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will wait for an element to be visible.
     *
     * @param element
     * @return
     */
    public static WebElement waitForVisibility(WebElement element){
        return getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }

}
