package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    public static final String email = "test@user.com";

    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailField;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

}
