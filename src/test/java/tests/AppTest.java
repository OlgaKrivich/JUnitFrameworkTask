package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddToBasketPopUp;
import pages.BasketPage;
import pages.HomePage;
import pages.PaymentPage;

public class AppTest {

    @Test
    public void verifyAddProductToBasket() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bookdepository.com/");

        HomePage homePage = new HomePage(driver);
        AddToBasketPopUp addToBasketPopUp = new AddToBasketPopUp(driver);
        BasketPage basketPage = new BasketPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        homePage.clickAddToBasketButton();
        addToBasketPopUp.clickCheckoutButton();
        Assertions.assertEquals(basketPage.getTotalCost(), "10,17 €");
        basketPage.clickBasketCheckoutButton();
        paymentPage.enterEmailAddress("test@user.com");

        driver.quit();
    }


}
