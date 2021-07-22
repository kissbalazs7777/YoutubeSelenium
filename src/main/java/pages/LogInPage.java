package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

    private WebDriver driver;
    private final By loginButton = By.xpath("/html/body/c-wiz/div/div/div/div[1]/div[1]/div/div/a");

    public boolean isLoginButtonVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }
}
