package pages;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CatalogCategoryPage extends BasePage {

    public By generateCategoryLocatorByName(String name) {
        return By.xpath(
                String.format("//*[contains(@class, 'link catalog-menu__list-item metrika i-bem metrika_js_inited') and text() = '%s']", name));
    }

    public void clickOnSubcategoryByName(String name) {
        By subcategoryLocator = generateCategoryLocatorByName(name);
        click(subcategoryLocator);
    }
}
