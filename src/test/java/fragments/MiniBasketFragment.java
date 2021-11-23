package fragments;

import static tests.AppTest.driver;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniBasketFragment {

    @FindBy(xpath = "//div[@class='mini-basket']")
    private WebElement fragmentRootElement;

    public MiniBasketFragment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String verifyCheckoutOrderSummary(String fieldName) {
        return driver.findElement(By.xpath(
                        "//dt/strong[contains(text(),'" + fieldName
                                + "')]/ancestor::dt/following-sibling::dd"))
                .getText();
    }

    public static Map<String,String> createHashMap(){
         Map<String,String> map = new HashMap<>();
         map.put("Sub-total","6,50 €");
         map.put("VAT","0,00 €");
         map.put("Total","6,50 €");
        return map;
    }

    public void verifyCheckoutOrderSummary(Map<String, String> map) {
         map.forEach((k,v) -> Assertions.assertEquals(
                        verifyCheckoutOrderSummary(k),v));
    }

}
