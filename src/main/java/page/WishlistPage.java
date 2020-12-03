package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitForElementMethods;

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