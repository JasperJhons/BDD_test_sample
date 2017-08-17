package pages;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends BasePage {

    private static String PAGEURL = "https://market.yandex.ru";


    public void openMainPage() {
        super.openPage(PAGEURL);
    }

    public void clickOnCategoryTab(String name) {
        By tabLocator = generateTopMenuLocatorByName(name);
        driver.findElement(tabLocator).click();
    }

    public By generateTopMenuLocatorByName(String name) {
        return By.xpath(String.format("//*[contains(@class, 'link topmenu__link') and text() = '%s']", name));
    }
}


