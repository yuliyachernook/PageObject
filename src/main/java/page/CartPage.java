package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitForElementMethods;

public class CartPage extends AbstractPage {

    private final By preliminaryProvisionLocator = By.xpath("//div[@class=\"row info-row\"][2]/div/span[@class=\"pull-right\"]");
    private final By costOfDeliverLocator = By.xpath("//div[@class=\"row info-row\"][3]/div/span[@class=\"pull-right\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Double getPreliminaryProvision() {
        String preliminaryProvisionText = WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, preliminaryProvisionLocator).getText().replace("BYN", "").
                replace(",", ".").trim();
        return Double.parseDouble(preliminaryProvisionText);
    }

    public String getCostOfDelivery() {
        return WaitForElementMethods.waitForElementLocatedBy(driver,
                WAIT_TIMEOUT_SECONDS, costOfDeliverLocator).getText().trim();
    }
}
