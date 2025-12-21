package update_cart_items;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class TestCartUpdate extends BaseTest {

    @Test
    public void updateTest(){
        var store = homePage.clickStoreMenu();
        store.addItemToCart();
        assertEquals(store.clickViewCartLink().updated("3"),30.0,"Expected price is 30.0");

    }
}
