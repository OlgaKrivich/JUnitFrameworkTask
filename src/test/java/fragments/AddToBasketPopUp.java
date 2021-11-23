package fragments;


import static tests.AppTest.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToBasketPopUp {

    public static final String totalCostExpected = "6,50 €";

    @FindBy(xpath = "//b[@class='pink-text big total']")
    private WebElement totalCost;

    @FindBy(xpath = " //div[@class='basket-info']//a[@href='/basket']")
    private WebElement basketCheckoutButton;

    public String getTotalCost() {
        wait.until(ExpectedConditions.visibilityOf(totalCost));
        return totalCost.getText();
    }

    public void clickBasketCheckoutButton() {
        basketCheckoutButton.click();
    }

    public AddToBasketPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
