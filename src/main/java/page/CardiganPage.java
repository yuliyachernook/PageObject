package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardiganPage extends AbstractPage {
    private static final String SELECTEDMODELPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/product/XSIDE/Для-женщин/Кардиган/4654470/1033617";
    @FindBy(className = "add-to-favorite-detail")
    private WebElement addSelectedModelToWishlist;

    @FindBy(className = "header-favorite-icon")
    private WebElement goToWishlist;

    public CardiganPage(WebDriver driver) {
        super(driver);
    }

    public CardiganPage addSelectedModelToWishlist() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(addSelectedModelToWishlist))
                .click();
        return this;
    }

    public WishlistPage goToWishlist() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToWishlist))
                .click();
        return new WishlistPage(driver);
    }

}