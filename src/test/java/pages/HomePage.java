package pages;

import static tests.AppTest.driver;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static final String productTitle = "Isaac Asimov";

    public void selectBookItem(String productTitle) {
        List<WebElement> booksList = driver.findElements(By.xpath("//div[@class='book-item']"));
        booksList.stream()
                .filter(book -> book
                        .findElement(By.xpath("//div[@class='book-item']//span[@itemprop='name']"))
                        .getText()
                        .equals(productTitle)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("No book found"))
                .findElement(By.xpath(
                        "//div[@class='book-item']//h3[@class='title']//ancestor::div//div[@class='item-img']"))
                .click();
    }
}
