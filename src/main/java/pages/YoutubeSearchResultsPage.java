package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YoutubeSearchResultsPage {

    private WebDriver driver;
    private final By firstVideoTitle = By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']");
    private final By stopOrStartVideoButton = By.xpath("//button[@class='ytp-play-button ytp-button']");

    public YoutubeVideoPage clickFirstResult(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(firstVideoTitle).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(stopOrStartVideoButton));
        return new YoutubeVideoPage(driver);
    }

    public YoutubeSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
}
