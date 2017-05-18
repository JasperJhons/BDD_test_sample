package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPage {

    private static final String pageUrl = "https://market.yandex.ru";

    private static final By TOP_MENU_TAB = By.xpath("//*[text()='Электроника']");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

        }

    public void clickOnTab(){
        driver.findElement(TOP_MENU_TAB).click();
    }

    public void openPage(){
        driver.get(pageUrl);
    }

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        MainPage m = new MainPage(driver);
        m.openPage();
        m.clickOnTab();
    }
    }


