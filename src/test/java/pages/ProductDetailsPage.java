package pages;

import static tests.AppTest.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage {

    @FindBy(xpath = "//a[@class='btn btn-primary add-to-basket']")
    private WebElement addToBasketButton;

    public void clickAddToBasketButton()  {
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketButton));
        addToBasketButton.click();
    }

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
