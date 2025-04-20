package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class SeleniumLibrary {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SeleniumLibrary(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Click element
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Send keys
    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    // Get text
    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // Wait for element visible
    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Submit form
    public void submit(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).submit();
    }

    // Navigate to URL
    public void openUrl(String url) {
        driver.get(url);
    }

    // Get current page title
    public String getTitle() {
        return driver.getTitle();
    }
    

        /**
         * Waits for an element to be visible.
         *
         * @param driver      The WebDriver instance.
         * @param by          The By locator of the element.
         * @param timeoutSec  Maximum wait time in seconds.
         * @param pollingSec  Polling interval in seconds.
         * @return The WebElement once it becomes visible.
         */
        public static WebElement waitForElementToBeVisible(WebDriver driver, By by, int timeoutSec, int pollingSec) {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutSec)) // Max wait time
                    .pollingEvery(Duration.ofSeconds(pollingSec)) // Polling interval
                    .ignoring(Exception.class); // Ignore specific exceptions (if any)

            // Wait for visibility of element
            return wait.until(driver1 -> {
                WebElement element = driver1.findElement(by);
                return (element != null && element.isDisplayed()) ? element : null;
            });
        }

        /**
         * Waits for an element to be clickable.
         *
         * @param driver      The WebDriver instance.
         * @param by          The By locator of the element.
         * @param timeoutSec  Maximum wait time in seconds.
         * @param pollingSec  Polling interval in seconds.
         * @return The WebElement once it becomes clickable.
         */
        public static WebElement waitForElementToBeClickable(WebDriver driver, By by, int timeoutSec, int pollingSec) {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutSec))
                    .pollingEvery(Duration.ofSeconds(pollingSec))
                    .ignoring(Exception.class);

            // Wait for the element to be clickable
            return wait.until(driver1 -> {
                WebElement element = driver1.findElement(by);
                return (element != null && element.isEnabled() && element.isDisplayed()) ? element : null;
            });
        }

        /**
         * Custom wait for an element based on a specific condition.
         *
         * @param driver      The WebDriver instance.
         * @param condition   The condition to wait for.
         * @param timeoutSec  Maximum wait time in seconds.
         * @param pollingSec  Polling interval in seconds.
         * @return The WebElement once the condition is satisfied.
         */
        public static WebElement waitForCondition(WebDriver driver, Function<WebDriver, WebElement> condition, int timeoutSec, int pollingSec) {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutSec))
                    .pollingEvery(Duration.ofSeconds(pollingSec))
                    .ignoring(Exception.class);

            // Wait for custom condition
            return wait.until(condition);
        }
    }

  