package filtering_products;

import base.BaseTest;
import org.testng.annotations.Test;

public class TestSlider extends BaseTest {

    @Test
    public void TestFilterByPriceSliding(){
        var slider = homePage.clickStoreMenu();
        // filter products by price by sliding to certain price range
        slider.slidePrice();
    }
}
