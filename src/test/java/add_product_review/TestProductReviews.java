package add_product_review;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestProductReviews extends BaseTest {
    @Test
    public void testAddReview(){
        var product = homePage.clickProductToReview();
        product.clickReview();
        product.addReview();

        String a = "Your review is awaiting approval";
        assertEquals(product.addedReview(),a,"Review is not added");
    }
}
