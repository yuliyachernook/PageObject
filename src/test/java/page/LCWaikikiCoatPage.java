package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LCWaikikiCoatPage extends AbstractPage {
    private static final String COATPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/product/LC-WAIKIKI/Для-женщин/Платье/4680126/1039095";
    @FindBy(css = "a[size=XL]")
    private WebElement setsize;

    @FindBy(id= "pd_add_to_cart")
    private WebElement addToCart;

    @FindBy(className= "header-bag-icon")
    private WebElement goToCart;

    public LCWaikikiCoatPage(WebDriver driver) {
        super(driver);
    }

    public LCWaikikiCoatPage openPage() {
        driver.get(COATPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public LCWaikikiCoatPage setSize() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(setsize))
                .click();
        return this;
    }

    public LCWaikikiCoatPage addToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(addToCart))
                .click();
        return this;
    }

    public LCWaikikiCartPage goToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(goToCart))
                .click();
        return new LCWaikikiCartPage(driver);
    }
}
