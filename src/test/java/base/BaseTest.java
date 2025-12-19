package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        homePage = new HomePage(driver);

    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
