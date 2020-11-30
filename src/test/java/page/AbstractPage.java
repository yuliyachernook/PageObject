package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Set;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS=30;

    protected AbstractPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    protected ExpectedCondition<Boolean> PageLoaded() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
    }
}
