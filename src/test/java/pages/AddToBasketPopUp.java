package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToBasketPopUp {

    @FindBy(xpath = "//div[@class='modal-body']//a[@href='/basket']")
    private WebElement popUpCheckoutButton;


    public void clickCheckoutButton() {
        popUpCheckoutButton.click();
    }

    public AddToBasketPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
