package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddToBasketPopUp;
import pages.BasketPage;
import pages.HomePage;
import pages.PaymentPage;

public class AppTest {

    @Test
    public void verifyAddProductToBasket() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        driver.manage().window().maximize();
        driver.get("https://www.bookdepository.com/");

        HomePage homePage = new HomePage(driver);
        AddToBasketPopUp addToBasketPopUp = new AddToBasketPopUp(driver);
        BasketPage basketPage = new BasketPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        homePage.clickAddToBasketButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='modal-body']//a[@href='/basket']")));
        Assertions.assertEquals(basketPage.getTotalCost(), "10,17 €");
        addToBasketPopUp.clickCheckoutButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='checkout-head-wrap']//a[@href='/payment/guest']")));
        basketPage.clickBasketCheckoutButton();
        Assertions.assertEquals(paymentPage.getTotalPrice(), "10,17 €");

        driver.quit();
    }


}
