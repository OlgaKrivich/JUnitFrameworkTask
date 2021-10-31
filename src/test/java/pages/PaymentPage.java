package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailAddress;

    public void enterEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
