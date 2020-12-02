package page;

import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LCWaikikiCartPage extends AbstractPage {
    private static final String CARTPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/mybag";
    @FindBy(xpath = "//div[@class=\"row info-row\"][3]/div/span[@class=\"pull-right\"]")
    private WebElement delivery;


    public LCWaikikiCartPage(WebDriver driver) {
        super(driver);
    }

    public LCWaikikiCartPage openPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(delivery));
        return this;
    }
    public String delivery() {
        WebElement del = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(delivery));
        return del.getText();
    }
}
