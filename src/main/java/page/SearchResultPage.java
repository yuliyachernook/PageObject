package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends AbstractPage {
    @FindBy(className = "a_model_item")
    private List<WebElement> searchResultList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CardiganPage goToModel() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(searchResultList)).get(1).click();
        return new CardiganPage(driver);
    }
}