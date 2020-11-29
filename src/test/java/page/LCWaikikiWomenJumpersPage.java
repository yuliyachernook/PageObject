package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LCWaikikiWomenJumpersPage extends AbstractPage {
    private static final String WOMENJUMPERSPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/category/women/jumpers-c63";
    @FindBy(id = "model_1038186_4778926")
    private WebElement goToSelectedModel;

    public LCWaikikiWomenJumpersPage(WebDriver driver){
        super(driver);
    }

    public LCWaikikiWomenJumpersPage openPage(){
        driver.get(WOMENJUMPERSPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public LCWaikikiSelectedModelPage goToSelectedModel(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToSelectedModel))
                .click();
        return new LCWaikikiSelectedModelPage(driver);
    }
}
