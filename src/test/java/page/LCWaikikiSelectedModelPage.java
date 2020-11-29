package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LCWaikikiSelectedModelPage extends AbstractPage {
    private static final String SELECTEDMODELPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/product/LC-WAIKIKI/Для-женщин/Джемпер/4778926/1038186";
    @FindBy(className = "add-to-favorite-detail")
    private WebElement addSelectedModelToWishlist;

    @FindBy(className = "header-favorite-icon")
    private WebElement goToWishlist;

    public LCWaikikiSelectedModelPage(WebDriver driver) {
        super(driver);
    }

    public LCWaikikiSelectedModelPage openPage() {
        driver.get(SELECTEDMODELPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public LCWaikikiSelectedModelPage addSelectedModelToWishlist() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addSelectedModelToWishlist))
                .click();
        return this;
    }

    public LCWaikikiWishlistPage goToWishlist() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToWishlist))
                .click();
        return new LCWaikikiWishlistPage(driver);
    }

}