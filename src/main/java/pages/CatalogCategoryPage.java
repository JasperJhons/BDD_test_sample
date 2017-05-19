package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogCategoryPage extends BasePage {

    CatalogCategoryPage(WebDriver driver) {
        super(driver);
    }

    public By generateCategoryLocatorByName(String name) {
        return By.xpath(
                String.format("//*[contains(@class, 'link catalog-menu__list-item metrika i-bem metrika_js_inited') and text() = '%s']", name));
    }

    public void clickOnSubcategoryByName(String name) {
        By subcategoryLocator = generateCategoryLocatorByName(name);
        click(subcategoryLocator);
    }
}
