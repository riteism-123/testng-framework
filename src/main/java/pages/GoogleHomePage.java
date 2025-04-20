package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumLibrary;

public class GoogleHomePage {

    SeleniumLibrary selenium;

    // Locators
    private By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        selenium = new SeleniumLibrary(driver);
    }

    public void enterSearch(String searchTerm) {
        selenium.sendKeys(searchBox, searchTerm);
    }

    public void submitSearch() {
        selenium.submit(searchBox);
    }

    public String getPageTitle() {
        return selenium.getTitle();
    }
}
