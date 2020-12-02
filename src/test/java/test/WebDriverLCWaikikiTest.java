package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LCWaikikiCoatPage;
import page.LCWaikikiCardiganPage;

public class WebDriverLCWaikikiTest {
    private WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void addOneModelToWishlistTest(){

        int p = new LCWaikikiCardiganPage(driver).openPage()
                .addSelectedModelToWishlist()
                .goToWishlist()
                .getsize();
        System.out.println(p);
        Assert.assertEquals(p, 1);
    }
    @Test
    public void freeDeliveryTest(){
        String del = new LCWaikikiCoatPage(driver).
                openPage().
                setSize().
                addToCart().
                goToCart().
                delivery().
                trim();
        Assert.assertEquals(del, "Бесплатно");
    }


    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
