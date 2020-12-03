package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.WaitForElementMethods;

import java.util.List;

public class WishlistPage extends AbstractPage {
    private final By favoriteItemsListLocator = By.className("favorite-item");

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public int getFavoriteItemsListSize() {
        return WaitForElementMethods.waitForElementsLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, favoriteItemsListLocator).size();
    }
}