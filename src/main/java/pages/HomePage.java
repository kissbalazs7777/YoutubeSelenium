package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;
    private final By languageSettings  = By.xpath("//div[25]/span");
    private final By huOptionFromLanguageSettings = By.xpath("//div[@data-value='hu']");
    private final By emailInput = By.name("identifier");
    private final By nextButton = By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By submitButton = By.id("passwordNext");
    private final By secondEmailInput = By.xpath("//input[@name='knowledgePreregisteredEmailResponse']");
    private final By continueButton = By.xpath("//div[1]/div/div/button/span");

    public void clickLanguageSettings(){
        driver.findElement(languageSettings).click();
    }

    public void clickHuOption(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(huOptionFromLanguageSettings).click();
    }

    public void typeEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
    }

    public void typePassword(String pw){
        driver.findElement(passwordInput).sendKeys(pw);
    }

    public YoutubeHomePage clickSubmitButton(){
        driver.findElement(submitButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(secondEmailInput));
            driver.findElement(secondEmailInput);
            clickSecondEmailInput();
            clickContinueButton();
        }catch (Exception e){
            return new YoutubeHomePage(driver);
        }
        return new YoutubeHomePage(driver);
    }

    public void clickSecondEmailInput(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(secondEmailInput).click();
    }

    public void clickContinueButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(continueButton).click();
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
