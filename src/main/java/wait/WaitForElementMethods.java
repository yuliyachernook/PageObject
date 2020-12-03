package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitForElementMethods {

    public static WebElement waitForElementLocatedBy(WebDriver driver, long time, By by) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static List<WebElement> waitForElementsLocatedBy(WebDriver driver, long time, By by) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
