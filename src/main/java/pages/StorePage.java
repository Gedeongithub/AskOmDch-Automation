package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StorePage {
    private WebDriver driver;

    public StorePage(WebDriver driver){
        this.driver = driver;
    }

    //method to search product
    public void searchProduct(String text){
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys(text);
        driver.findElement(By.xpath("//button[@value='Search']")).click();
    }

    //Results of searched products amount
    public boolean areResults(String txt){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement parent = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".products.columns-4"))));
        List<WebElement> results = null;
        if (parent != null) {
            results = parent.findElements(By.tagName("li"));
        }
        boolean yes = false;
        for(WebElement li:results){
            if(li.getText().contains(txt)){
                yes = true;
            }
        }
        return yes;
    }

    //method to filter product by price sliding

    public void slidePrice() {
        By button = By.xpath("//button[contains(text(),'Filter')]");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("""
                let slider = document.querySelector('.price_slider');
                slider.setAttribute('data-values','20,80');
                """);
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(button)).perform();
        driver.findElement(button).click();
    }

    // Method to add product to cart
    public void dropDownToSelect(String category){
        WebElement scrollToMe =driver.findElement(By.xpath("//h2[contains(text(),'Filter by price')]"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(scrollToMe).perform();

        WebElement parent = driver.findElement(By.id("product_cat"));
        new Select(parent).selectByValue(category);
    }

    public void addProductToCart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),'Add to cart')]"));
        int amount = 0;
        for(WebElement product:elements){
            product.click();
            amount++;
            if(amount == 4){
                return;
            }
        }

    }
    //Method to hover and navigate to cart to view cart

    public void hoverOverCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("count"))).perform();
    }

    //Wait for products to be added all in cart before you click checkout

    public CheckoutPage checkOut(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(driver -> driver.findElements(By.cssSelector(".woocommerce-mini-cart-item.mini_cart_item")).size()>4);
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
        return new CheckoutPage(driver);
    }

    //Add an item to cart
    public StorePage addItemToCart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return this;
    }

    public CartPage clickViewCartLink(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        By viewCart = By.cssSelector("a.added_to_cart.wc-forward");
        WebElement element =wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        element.click();
        return new CartPage(driver);
    }
}
//