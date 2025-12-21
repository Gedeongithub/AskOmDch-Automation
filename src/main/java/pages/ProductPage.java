package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    By reviewButton = By.xpath("//a[contains(text(),'Review')]");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    //Click review button
    public void clickReview(){
        driver.findElement(reviewButton).click();
        scroll();
    }

    //scroll to review
    private void scroll(){
        WebElement elementTowait = driver.findElement(By.id("submit"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementTowait));
        Actions action = new Actions(driver);
        if (element != null) {
            action.scrollToElement(element).perform();
        }
    }

    //Fill in review
    public void addReview(){
        By star = By.className("star-4");
        By comment = By.id("comment");
        By submit = By.id("submit");
        By name = By.id("author");
        By email = By.id("email");

        driver.findElement(star).click();
        driver.findElement(comment).sendKeys("The best product ever");
        driver.findElement(name).sendKeys("Gedeon");
        driver.findElement(email).sendKeys("gdufitimana@gmail.com");
        driver.findElement(submit).click();

    }
    //Method to return review if added sucessfully
    public String addedReview(){
        By review = By.xpath("//em[contains(text(),'Your review is awaiting approval')]");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement permissionText = wait.until(ExpectedConditions.visibilityOfElementLocated(review));

        if (permissionText != null) {
            return permissionText.getText();
        }
        return "Not found";
    }
}
