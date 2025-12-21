package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage {
    private WebDriver driver;

    public SuccessPage(WebDriver driver){
        this.driver = driver;
    }

    public String orderSuccess(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.woocommerce-thankyou-order-received")));
        return element.getText();
    }
}
