package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductListPage extends BasePage {

    public static final By PRODUCT_TITLE = By.xpath("//*[@class=\"snippet-card__header-text\"]");
    public static final By PRICE_FROM_FIELD = By.id("glf-pricefrom-var");

    ProductListPage(WebDriver driver) {
        super(driver);
    }

    public By generateFilterParameterLocator(String name){
        return By.xpath(String.format("//*[contains(@class, 'checkbox__label') and text() = '%s']",name));
    }

    public void setFiltersParameters(List<String> parameters){
        for (String param: parameters){
            setFilterparameter(param);
        }
    }

    public  void setFilterparameter(String param){
        WebElement paramElement = driver.findElement(generateFilterParameterLocator(param));
        moveToElement(paramElement);
        paramElement.click();
    }

    public void setPriceFromFiltersValue(String priceFrom){
        setValueToField(PRICE_FROM_FIELD,priceFrom);
    }

    public List<WebElement> getAllProductsTitleElements(){
        sleep(4);
        return driver.findElements(PRODUCT_TITLE);
    }

    public ProductPage openProductPageByIndex(int index){
        List<WebElement> allProducts = getAllProductsTitleElements();
        WebElement targetProduct = allProducts.get(index);
        targetProduct.click();
        return new ProductPage(driver,getText(targetProduct));
    }


}
