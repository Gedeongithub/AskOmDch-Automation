package checkout;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout(){
        var store = homePage.clickStoreMenu();
        store.dropDownToSelect("men");
        store.addProductToCart();

        store.hoverOverCart();
        var shippingPage =store.checkOut();
        shippingPage.fillShippingData();
        var success = shippingPage.clickPlaceOrder();

        assertEquals(success.orderSuccess(),"Thank you. Your order has been received.","failed to place an order");
    }
}
