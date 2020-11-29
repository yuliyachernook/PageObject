package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LCWaikikiHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY";
    Actions actionProvider;
    @FindBy(id = "menu_1")
    private WebElement womenMenuItem;

    @FindBy(xpath = "//ul[@id=\"dd_mmm_1_3\"]/li[7]")
    private WebElement jumperMenuItem;

    public LCWaikikiHomePage(WebDriver driver){
        super(driver);
        actionProvider = new Actions(driver);
    }

    public LCWaikikiHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public LCWaikikiHomePage openWomenMenuItem(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(womenMenuItem));
        actionProvider.moveToElement(womenMenuItem).build().perform();
        return this;
    }
    public LCWaikikiWomenJumpersPage openJumperMenuItem(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(jumperMenuItem))
                .click();
        return new LCWaikikiWomenJumpersPage(driver);
    }
}