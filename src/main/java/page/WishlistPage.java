package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WishlistPage extends AbstractPage {
    @FindBy(className = "favorite-item")
    private List<WebElement> favoriteItemsList;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public int getsize() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(favoriteItemsList));
        return favoriteItemsList.size();
    }

}