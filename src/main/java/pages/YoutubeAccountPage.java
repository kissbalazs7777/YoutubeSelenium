package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YoutubeAccountPage {

    private WebDriver driver;
    private final By spanWithUsedEmail = By.xpath("//span[text()='ladatolcsontesztelek@gmail.com']");

    public String getTextFromSpan(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(spanWithUsedEmail));
        return driver.findElement(spanWithUsedEmail).getText();
    }

    public YoutubeAccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
