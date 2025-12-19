package filtering_products;

import base.BaseTest;
import org.testng.annotations.Test;

public class TestSlider extends BaseTest {

    @Test
    public void TestFilterByPriceSliding(){
        var slider = homePage.clickStoreMenu();
        slider.slidePrice();
    }
}
