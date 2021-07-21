package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected String email = "ladatolcsontesztelek@gmail.com";
    protected String pw = "QA123456";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=hu");
        driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
