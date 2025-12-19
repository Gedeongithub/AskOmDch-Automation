package scroll_to_featured_products;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class ScrollToFeaturedProductsTest extends BaseTest {

    @Test
    public void testFeaturedProductScroll(){
        String textToCompare = "Featured Products";
        var scroll = homePage;
        homePage.ScrollToFeaturedProduct();
        assertEquals(homePage.ScrollToFeaturedProduct(),textToCompare,"Can't scroll to that point");
    }
}
