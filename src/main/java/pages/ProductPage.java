package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage extends BasePage {

    private String targetProductName;

    public static final By PRODUCT_TITLE = By.xpath(".//*[contains(@itemprop,\"name\")]");


    ProductPage(WebDriver driver) {
        super(driver);
    }

    ProductPage(WebDriver driver, String targetProductName) {
        super(driver);
        this.targetProductName = targetProductName;
    }

    public String getCurrentProductName() {
        return getText(driver.findElement(PRODUCT_TITLE));
    }

    public String getTargetProductName() {
        return targetProductName;
    }
}
