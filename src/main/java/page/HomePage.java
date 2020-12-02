package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY";

    @FindBy(className ="hs-search-button")
    private WebElement searchButton;

    @FindBy(id ="search")
    private WebElement searchInput;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage(){
            driver.get(HOMEPAGE_URL);
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(searchButton));
            return this;
    }

    public SearchResultPage searchForModel(String searchRequest) {
        searchButton.click();
        searchInput.sendKeys(searchRequest);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}