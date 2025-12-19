package search_product;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchProductTest extends BaseTest {

    @Test
    public void testSearch(){
        var search = homePage.clickStoreMenu();
        String text = "Blue";
        search.searchProduct(text);
        assertEquals(search.areResults(text),true,"Results does not match");
    }
}
