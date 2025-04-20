package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GoogleHomePage;
import utils.ChromeProfileManager;
import utils.ConfigReader;
import utils.SeleniumLibrary;

public class GoogleSearchTest {

    WebDriver driver;
    GoogleHomePage google;

    @BeforeMethod
    public void setup() {
    	WebDriverManager.chromedriver().setup();

        // Use Chrome with a unique profile directory for each test
        driver = ChromeProfileManager.getDriverWithProfile("Default", false);

        driver.manage().window().maximize();
        google = new GoogleHomePage(driver);
    }

    @Test
    public void testSearch() {
        String baseUrl = ConfigReader.get("base.url");
        driver.get(baseUrl);

        google.enterSearch("ChatGPT TestNG POM");
        google.submitSearch();
        
        
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        

        
        

        String title = google.getPageTitle();
        Assert.assertTrue(title.contains("ChatGPT"));
    }
    
    @Test(enabled =false)
    public void testFluentWait() {
        // Setup WebDriver (Chrome, Firefox, etc.)
        driver = new ChromeDriver();
        driver.get("https://example.com");

        // Use FluentWaitUtil to wait for an element to become visible
        WebElement element = SeleniumLibrary.waitForElementToBeVisible(
                driver, 
                By.id("example-element-id"), 
                10, // Wait for a max of 10 seconds
                2  // Poll every 2 seconds
        );

        // Now that the element is visible, you can interact with it
        element.click();

        // Close the browser
        driver.quit();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
