package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Methods to be called to scroll and return featured products
    public String ScrollToFeaturedProduct(){
        WebElement targetElement = driver.findElement(By.cssSelector(".products.columns-5"));
        WebElement text = driver.findElement(By.xpath("//h2[contains(text(),'Featured Products')]"));
        Actions action = new Actions(driver);
        action.scrollToElement(targetElement).perform();
        return text.getText();

    }

    //method to create an Account
    public CreateAccountPage goCreateAccount(){
        driver.findElement(By.linkText("Account")).click();
        return new CreateAccountPage(driver);
    }

    //method to log in with existing account
    public LoginPage goLogin(){
        driver.findElement(By.linkText("Account")).click();
        return new LoginPage(driver);
    }

    //Adding review to product
    public ProductPage clickProductToReview(){
        List<WebElement> products = driver.findElements(By.className("woocommerce-loop-product__title"));
        System.out.println("Length: "+products.size());
        WebElement product = products.getFirst();
        product.click();
        return new ProductPage(driver);
    }

    //Searching product from store products page

    public StorePage clickStoreMenu(){
        driver.findElement(By.xpath("//a[contains(text(),'Store')]")).click();
        return new StorePage(driver);
    }


}
