package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private final By emailInput = By.name("identifier");
    private final By nextButton = By.xpath("//span[text()='Következő']");
    private final By passwordInput = By.name("password");
    private final By submitButton = By.id("passwordNext");

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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
