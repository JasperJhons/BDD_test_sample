package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends BasePage {

    public static final By PRODUCT_TITLE = By.xpath(".//*[contains(@itemprop,\"name\")]");
    @Getter
    @Setter
    private String targetProductName;

    public String getCurrentProductName() {
        return getText(driver.findElement(PRODUCT_TITLE));
    }

}
