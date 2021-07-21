package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private final By languageSettings  = By.xpath("//div[25]/span");
    private final By huOptionFromLanguageSettings = By.xpath("//div[@data-value='hu']");
    private final By emailInput = By.name("identifier");
    private final By nextButton = By.xpath("//span[text()='Következő']");
    private final By passwordInput = By.name("password");
    private final By submitButton = By.id("passwordNext");

    public void clickLanguageSettings(){
        driver.findElement(languageSettings).click();
    }

    public void clickHuOption(){
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
        return new YoutubeHomePage(driver);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
