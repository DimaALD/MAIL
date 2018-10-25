package utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    public static final int WAIT_FOR_SECONDS = 10;

    public static void waitForElementVisible(WebDriver driver , WebElement element) {
        new WebDriverWait(driver, WAIT_FOR_SECONDS).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void waitForElementVisible(WebDriver driver , By locator) {
        new WebDriverWait(driver, WAIT_FOR_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitForElementClickable(WebDriver driver , By locator) {
        new WebDriverWait(driver, WAIT_FOR_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementClickable(WebDriver driver , WebElement element) {
        new WebDriverWait(driver, WAIT_FOR_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

}
