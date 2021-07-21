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
        driver.get("https://accounts.google.com/signin/v2/identifier?service=youtube&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dhu%26next%3Dhttps%253A%252F%252Fwww.youtube.com%252F&hl=hu&ec=65620&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
