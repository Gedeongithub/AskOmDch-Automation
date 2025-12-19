package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class CreateAccountPage {
    private WebDriver driver;
    private final By username = By.id("reg_username");
    private final By email = By.id("reg_email");
    private final By password = By.id("reg_password");
    private final By submit = By.cssSelector("button[name='register']");
    //Constructor
    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
    }

   //method to fill out data and register
    public void fillOutUserData(String username, String email, String password){

        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(submit).click();

    }
    public String successAccountCreation(){
        return driver.findElement(By.xpath("//p[contains(text(),'Hello')]")).getText();
    }
}
