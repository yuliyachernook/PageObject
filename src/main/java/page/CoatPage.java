package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoatPage extends AbstractPage {
    private static final String COATPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/product/XSIDE/Для-женщин/Пальто/4650524/1048121";

    private static String sizeTemplate = "a[size=$]";
    private static String colorTemplate = "//div[@class=\"color-box\"]/div[@title=\"$\"]";

    @FindBy(id= "pd_add_to_cart")
    private WebElement addToCart;

    @FindBy(className= "header-bag-icon")
    private WebElement goToCart;

    public CoatPage(WebDriver driver) {
        super(driver);
    }

    public CoatPage openPage() {
        driver.get(COATPAGE_URL);
        return this;
    }

    public CoatPage setSize(String size) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(sizeTemplate.replace("$", size)))).
                click();
        return this;
    }

    public CoatPage setColor(String color) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(colorTemplate.replace("$", color)))).
                click();
        return this;
    }

    public CoatPage addToCart() {
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
