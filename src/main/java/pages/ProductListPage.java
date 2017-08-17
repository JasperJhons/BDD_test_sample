package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductListPage extends BasePage {

    public static final By PRODUCT_TITLE = By.xpath("//*[@class=\"snippet-card__header-text\"]");
    public static final By PRICE_FROM_FIELD = By.id("glf-pricefrom-var");
    public static final By PRICE_TO_FIELD = By.id("glf-priceto-var");


    public By generateFilterParameterLocator(String name) {
        return By.xpath(String.format("//*[contains(@class, 'checkbox__label') and text() = '%s']", name));
    }

    public void setFiltersParameters(List<String> parameters) {
        for (String param : parameters) {
            setFilterparameter(param);
        }
    }

    public void setFilterparameter(String param) {
        WebElement paramElement = driver.findElement(generateFilterParameterLocator(param));
        moveToElement(paramElement);
        paramElement.click();
    }

    public void setPriceFromFiltersValue(String priceFrom) {
        setValueToField(PRICE_FROM_FIELD, priceFrom);
    }

    public void setPriceToFiltersValue(String priceTo) {
        setValueToField(PRICE_TO_FIELD, priceTo);
    }

    public List<WebElement> getAllProductsTitleElements() {
        sleep(7);
        return driver.findElements(PRODUCT_TITLE);
    }

    public void openProductPageByIndex(int index, ProductPage page) {
        List<WebElement> allProducts = getAllProductsTitleElements();
        WebElement targetProduct = allProducts.get(index);
        targetProduct.click();
        page.setTargetProductName(getText(targetProduct));
    }


}
