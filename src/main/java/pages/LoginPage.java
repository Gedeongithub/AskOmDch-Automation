package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillCredentials(){
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Gedeon");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[name='login']")).click();

    }

    public String successLogin(){
        return driver.findElement(By.xpath("//p[contains(text(),'Hello')]")).getText();
    }
}


