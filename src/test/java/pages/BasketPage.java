package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {


    @FindBy(xpath = "//span[@id='basket-total-cost']/b")
    private WebElement totalCost;

    @FindBy(xpath = "//div[@class='checkout-head-wrap']//a[@href='/payment/guest']")
    private WebElement basketCheckoutButton;

    public String getTotalCost() {
        return totalCost.getText();
    }

    public void clickBasketCheckoutButton() {
        basketCheckoutButton.click();
    }

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
