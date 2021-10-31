package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    @FindBy(xpath = "//a[@data-isbn='9781471156267']")
    private WebElement addToBasketButton;

    public void clickAddToBasketButton() {
        addToBasketButton.click();
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
