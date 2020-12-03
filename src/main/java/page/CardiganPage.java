package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitForElementMethods;

public class CardiganPage extends AbstractPage {

    private final By addModelToWishlistLocator = By.className("add-to-favorite-detail");
    private final By goToWishlistLocator = By.className("header-favorite-icon");

    public CardiganPage(WebDriver driver) {
        super(driver);
    }

    public CardiganPage addModelToWishlist() {
        WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, addModelToWishlistLocator).click();
        return this;
    }

    public WishlistPage goToWishlist() {
        WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, goToWishlistLocator).click();
        return new WishlistPage(driver);
    }
}