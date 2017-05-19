package steps;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Pages;

import java.util.concurrent.TimeUnit;

public class MarketSteps {

    private Pages pages;

    @BeforeStory
    public void prepareBeforeScenario() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.pages = new Pages(driver);
    }

    @AfterStory
    public void cleanDataAfterScenario() {
        pages.driver.quit();
    }

    @Given("Yandex market main page")
    public void yandexMarketMainPageOpen() {
        pages.mainPage().openMainPage();
    }

    @When("Click on $category category tab in main menu")
    public void clickOnCategoryTabInMain(String category) {
        pages.mainPage().clickOnCategoryTab(category);
    }

    @When("Click on $category category link in left menu")
    public void clickOnCategoryLinkInLeft(String category) {
        pages.catalogCategoryPage().clickOnSubcategoryByName(category);
    }

    @When("Set from price parameter as $parameter")
    public void setFromPriceParametre(String parametеr) {
        pages.productListPage().setPriceFromFiltersValue(parametеr);
    }

    @When("Set to price parameter as $parameter")
    public void setToPriceParametre(String parametеr) {
        pages.productListPage().setPriceToFiltersValue(parametеr);
    }

    @When("Set filters parameter as $parameter")
    public void setFiltersParametre(String parameter) {
        pages.productListPage().setFilterparameter(parameter);
    }

    @When("Open product in $position position in list")
    public void setFiltersParametre(int position) {
        pages.setProductPage(pages.productListPage().openProductPageByIndex(--position));
    }

    @Then("Check what right product is open")
    public void checkRightProductIsOpen() {
        Assert.assertEquals(pages.productPage().getCurrentProductName(),
                pages.productPage().getTargetProductName());
    }
}

