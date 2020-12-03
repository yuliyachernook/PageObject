package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.WaitForElementMethods;

public class HomePage extends AbstractPage {

    private final By searchButtonLocator = By.className("hs-search-button");
    private final By searchInputLocator = By.id("search");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultPage searchForModel(String searchRequest) {
        WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, searchButtonLocator).click();
        WebElement searchInput = WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, searchInputLocator);
        searchInput.sendKeys(searchRequest);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}