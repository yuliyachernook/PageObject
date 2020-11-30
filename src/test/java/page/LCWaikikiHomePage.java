package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class LCWaikikiHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY";
    Actions actionProvider;
    String windowHandler;
    @FindBy(id = "menu_1")
    private WebElement womenMenuItem;

    @FindBy(xpath = "//ul[@id=\"dd_mmm_1_3\"]/li[7]")
    private WebElement jumperMenuItem;
    @FindBy(xpath = "//*[@id=\"wps-ribbon_TOP_false\"]")
    private WebElement close;

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

    public LCWaikikiWomenJumpersPage openWomenMenuItem(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(womenMenuItem)).click();
        return new LCWaikikiWomenJumpersPage(driver);
    }

//
//    public LCWaikikiHomePage close(){
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"wps-ribbon_TOP_false\"]/div[2]")))
//                .click();
//        return this;
//    }
}
