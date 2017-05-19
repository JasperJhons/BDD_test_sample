package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {

    String pageUrl = "https://market.yandex.ru";

    MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        super.openPage(pageUrl);
    }

    public void clickOnCategoryTab(String name) {
        By tabLocator = generateTopMenuLocatorByName(name);
        driver.findElement(tabLocator).click();
    }

    public By generateTopMenuLocatorByName(String name) {
        return By.xpath(String.format("//*[contains(@class, 'link topmenu__link') and text() = '%s']", name));
    }
}


