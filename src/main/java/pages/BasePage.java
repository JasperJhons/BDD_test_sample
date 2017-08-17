package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        moveToElement(element);
        element.click();
    }

    public void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public List<WebElement> getAllElementsByLocator(By locator) {
        return driver.findElements(locator);
    }

    public void setValueToField(By field, String value) {
        WebElement fieldElement = driver.findElement(field);
        moveToElement(fieldElement);
        fieldElement.sendKeys(value);
    }

    public void moveToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    //Я знаю, что это очень плохой способ ждать, но в данном случае он мне нужен для обновления списка товаров
    public void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
