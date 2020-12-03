package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitForElementMethods;

public class CoatPage extends AbstractPage {

    private static String sizeTemplate = "a[size=$]";
    private static String colorTemplate = "//div[@class=\"color-box\"]/div[@title=\"$\"]";

    private final By addToCartLocator = By.id("pd_add_to_cart");
    private final By goToCartLocator = By.className("header-bag-icon");

    public CoatPage(WebDriver driver) {
        super(driver);
    }

    public CoatPage openPage() {
        driver.get(COATPAGE_URL);
        return this;
    }

    public CoatPage setSize(String size) {
        WaitForElementMethods.waitForElementLocatedBy(driver, WAIT_TIMEOUT_SECONDS,
                By.cssSelector(sizeTemplate.replace("$", size))).click();
        return this;
    }

    public CoatPage setColor(String color) {
        WaitForElementMethods.waitForElementLocatedBy(driver, WAIT_TIMEOUT_SECONDS,
                By.xpath(colorTemplate.replace("$", color))).click();
        return this;
    }

    public CoatPage addModelToCart() {
        WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, addToCartLocator).click();
        return this;
    }

    public CartPage goToCart() {
        WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, goToCartLocator).click();
        return new CartPage(driver);
    }
}
