package tests;


import static fragments.AddToBasketPopUp.totalCostExpected;
import static fragments.MiniBasketFragment.createHashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.HomePage.productTitle;
import static pages.PaymentPage.email;

import fragments.AddToBasketPopUp;
import fragments.MiniBasketFragment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasketPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductDetailsPage;

public class AppTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000);
        driver.manage().window().maximize();
        driver.get("https://www.bookdepository.com/");
    }

    @Test
    public void verifyAddProductToBasket() {
        HomePage homePage = new HomePage(driver);
        AddToBasketPopUp addToBasketPopUp = new AddToBasketPopUp(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        MiniBasketFragment miniBasketFragment = new MiniBasketFragment(driver);

        homePage.selectBookItem(productTitle);
        productDetailsPage.clickAddToBasketButton();
        assertEquals(totalCostExpected, addToBasketPopUp.getTotalCost());
        addToBasketPopUp.clickBasketCheckoutButton();
        basketPage.clickCheckoutButton();
        paymentPage.fillEmailField(email);
        miniBasketFragment.verifyCheckoutOrderSummary(createHashMap());
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }

}
