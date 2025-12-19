package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class CheckoutPage {
    private WebDriver driver;
    By firstName = By.id("billing_first_name");
    By lastName = By.id("billing_last_name");
    By countries_selection = By.id("billing_country");
    By street_address = By.id("billing_address_1");
    By city = By.id("billing_city");
    By city_selection = By.id("billing_state");
    By zip_code = By.id("billing_postcode");
    By email = By.id("billing_email");
    By place_order_button = By.id("place_order");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

//Method to fill in address information
    public void fillShippingData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstName))).sendKeys("Gedeon");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(lastName))).sendKeys("Dufitimana");
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(countries_selection))));
        select.selectByValue("US");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(street_address))).sendKeys("Nyarutarama");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(city))).sendKeys("Kigali");
        Select select1 = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(city_selection))));
        select1.selectByValue("NH");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(zip_code))).sendKeys("00000");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(email))).sendKeys("gdufitimana@gmail.com");

    }

    public SuccessPage clickPlaceOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver ->
                (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return jQuery.active === 0")
        );
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(place_order_button)))).click();
        return new SuccessPage(driver);
    }


}
