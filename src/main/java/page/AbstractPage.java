package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected static final String HOMEPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY";
    protected static final String COATPAGE_URL = "https://www.lcwaikiki.by/ru-RU/BY/product/XSIDE/Для-женщин/Пальто/4650524/1048121";
    protected static final int WAIT_TIMEOUT_SECONDS = 15;

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        driver.manage().window().maximize();
    }
}
