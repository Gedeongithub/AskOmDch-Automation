package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

public double updated(String num) {

    By unitPrice = By.cssSelector("td.product-price bdi");
    By totalPrice = By.cssSelector("td.product-subtotal bdi");
    By updateButton = By.name("update_cart");
    By qtyInput = By.cssSelector("input.qty");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    String unitPriceText = wait
            .until(ExpectedConditions.visibilityOfElementLocated(unitPrice))
            .getText()
            .replace("$", "");

    double unit = Double.parseDouble(unitPriceText);

    WebElement qty = driver.findElement(qtyInput);
    qty.clear();
    qty.sendKeys(num);

    double expectedSum = unit * Double.parseDouble(num);
    System.out.println("Expected sum: " + expectedSum);

    String oldTotal = driver.findElement(totalPrice).getText();

    wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();

    wait.until(driver ->
            (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return jQuery.active === 0")
    );

    wait.until(ExpectedConditions.not(
            ExpectedConditions.textToBe(totalPrice, oldTotal)
    ));

    String newTotalText = driver.findElement(totalPrice)
            .getText()
            .replace("$", "");

    double actualSum = Double.parseDouble(newTotalText);

    System.out.println("Actual sum: " + actualSum);
    return actualSum;
}


}
