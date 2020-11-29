package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LCWaikikiWishlistPage extends AbstractPage {
    private static final String WISHLISTPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/myfavoritelist";
    @FindBy(className = "favorite-item")
    private List<WebElement> favoriteItemsList;

    public LCWaikikiWishlistPage(WebDriver driver) {
        super(driver);
    }

    public LCWaikikiWishlistPage openPage() {
        driver.get(WISHLISTPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public int getsize() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(favoriteItemsList));
        return favoriteItemsList.size();
    }

}