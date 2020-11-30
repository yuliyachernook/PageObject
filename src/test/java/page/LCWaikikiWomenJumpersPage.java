package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LCWaikikiWomenJumpersPage extends AbstractPage {
    private static final String WOMENJUMPERSPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/product-group/women";
    @FindBy(xpath = "//*[@id=\"model_1038186_4778926\"]")
    private WebElement goToSelectedModel;


    @FindBy(xpath = "//*[@id=\"model_1033618_4654470\"]")
    private WebElement goToSelectedModel2;

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
                .until(ExpectedConditions.elementToBeClickable(goToSelectedModel2))
                .click();
        return new LCWaikikiSelectedModelPage(driver);
    }
}
