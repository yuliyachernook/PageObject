package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.CartPage;
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
                .addModelToWishlist()
                .goToWishlist()
                .getFavoriteItemsListSize();

        Assert.assertEquals(favoriteItemsListSize, 1);
    }
    @Test
    public void freeDeliveryWhenOrderAmountIsMoreThanSeventyTest(){
        SoftAssert softly = new SoftAssert();
        CartPage cartPage = new CoatPage(driver)
                .openPage()
                .setColor("Grey Melange")
                .setSize("M")
                .addModelToCart()
                .goToCart();
        
        softly.assertEquals(cartPage.getPreliminaryProvision(), 99.95);
        softly.assertTrue(cartPage.getPreliminaryProvision() > 70, "A preliminary provision is less than 70 BYN.");
        softly.assertEquals(cartPage.getCostOfDelivery(), "Бесплатно");
        softly.assertAll();
    }

    @AfterMethod
    public void driverTearDown(){
        driver.quit();
        driver = null;;
    }
}
