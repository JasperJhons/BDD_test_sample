package steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pages.Pages;

@Component
public class MarketSteps {

    @Autowired
    private Pages pages;

    @AfterStory
    public void cleanDataAfterScenario() {
        pages.getDriver().quit();
    }

    @Given("Yandex market main page")
    public void yandexMarketMainPageOpen() {
        pages.getMainPage().openMainPage();
    }

    @When("Click on $category category tab in main menu")
    public void clickOnCategoryTabInMain(String category) {
        pages.getMainPage().clickOnCategoryTab(category);
    }

    @When("Click on $category category link in left menu")
    public void clickOnCategoryLinkInLeft(String category) {
        pages.getCatalogCategoryPage().clickOnSubcategoryByName(category);
    }

    @When("Set from price parameter as $parameter")
    public void setFromPriceParameter(String parameter) {
        pages.getProductListPage().setPriceFromFiltersValue(parameter);
    }

    @When("Set to price parameter as $parameter")
    public void setToPriceParameter(String parameter) {
        pages.getProductListPage().setPriceToFiltersValue(parameter);
    }

    @When("Set filters parameter as $parameter")
    public void setFiltersParameter(String parameter) {
        pages.getProductListPage().setFilterparameter(parameter);
    }

    @When("Open product in $position position in list")
    public void setFiltersParameter(int position) {
        pages.getProductListPage().openProductPageByIndex(position, pages.getProductPage());
    }

    @Then("Check what right product is open")
    public void checkRightProductIsOpen() {
        Assert.assertEquals(pages.getProductPage().getCurrentProductName(),
                pages.getProductPage().getTargetProductName());
    }
}

