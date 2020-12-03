package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.WaitForElementMethods;

public class CartPage extends AbstractPage {
    private final By costOfDeliverLocator = By.xpath("//div[@class=\"row info-row\"][3]/div/span[@class=\"pull-right\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCostOfDelivery() {
        return WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, costOfDeliverLocator).getText();
    }
}
