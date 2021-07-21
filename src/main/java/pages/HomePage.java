package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class HomePage {

    private WebDriver driver;
    private final By loginButton = By.xpath("//a[@aria-label='Bejelentkezés']");

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public int getLoginButton(){
        ArrayList<WebElement> loginButtons = new ArrayList<>();
        loginButtons.add(driver.findElement(loginButton));
        return loginButtons.size();
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
