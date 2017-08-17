package pages;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Pages extends BasePage {

    @Autowired
    MainPage mainPage;

    @Autowired
    CatalogCategoryPage catalogCategoryPage;

    @Autowired
    ProductListPage productListPage;

    @Autowired
    ProductPage productPage;

}
