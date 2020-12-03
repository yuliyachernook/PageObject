package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitForElementMethods;

public class SearchResultPage extends AbstractPage {
    private final By searchResultListLocator = By.className("a_model_item");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CardiganPage goToModel() {
        WaitForElementMethods.waitForElementsLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, searchResultListLocator).get(1).click();
        return new CardiganPage(driver);
    }
}