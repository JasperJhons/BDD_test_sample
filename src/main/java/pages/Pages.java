package pages;

import org.openqa.selenium.WebDriver;


public class Pages {

    public final WebDriver driver;

    private MainPage mainPage;
    private CatalogCategoryPage catalogCategoryPage;
    private ProductListPage productListPage;
    private ProductPage productPage;

    public Pages(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(driver);
        }
        return mainPage;
    }

    public CatalogCategoryPage catalogCategoryPage() {
        if (catalogCategoryPage == null) {
            catalogCategoryPage = new CatalogCategoryPage(driver);
        }
        return catalogCategoryPage;
    }

    public ProductListPage productListPage() {
        if (productListPage == null) {
            productListPage = new ProductListPage(driver);
        }
        return productListPage;
    }

    public ProductPage productPage() {
        if (productPage == null) {
            productPage = new ProductPage(driver);
        }
        return productPage;
    }

    public void setProductPage(ProductPage productPage) {
        this.productPage = productPage;
    }
}
