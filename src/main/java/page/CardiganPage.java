package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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