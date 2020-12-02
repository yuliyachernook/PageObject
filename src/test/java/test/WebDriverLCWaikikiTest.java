package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.CoatPage;
import page.HomePage;

public class WebDriverLCWaikikiTest {
    private WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void addOneModelToWishlistTest() {
        int favoriteItemsListSize = new HomePage(driver)
                .openPage()
                .searchForModel("0WDF15Z8")
                .goToModel()
                .addSelectedModelToWishlist()
                .goToWishlist()
                .getsize();
        System.out.println(favoriteItemsListSize);

        Assert.assertEquals(favoriteItemsListSize, 1);
    }
    @Test
    public void freeDeliveryTest(){
        String сostOfDelivery = new CoatPage(driver).
                openPage().
                setColor("Grey Melange").
                setSize("M").
                addToCart().
                goToCart().
                delivery().
                trim();
        Assert.assertEquals(сostOfDelivery, "Бесплатно");
    }

    @AfterMethod
    public void driverTearDown(){
        driver.quit();
        driver = null;;
    }
}
