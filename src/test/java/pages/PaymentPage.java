package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    @FindBy(xpath = "//div[@class='mini-basket']//dl[@class='order-summary-last-dl']/dd")
    private WebElement totalPrice;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
