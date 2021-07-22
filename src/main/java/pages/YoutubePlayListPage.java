package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YoutubePlayListPage {

    private WebDriver driver;
    private final By kebabMenu = By.xpath("//div[4]/ytd-menu-renderer/yt-icon-button/button");
    private final By deletePlaylistButton = By.xpath("//ytd-menu-service-item-renderer[4]/tp-yt-paper-item/yt-formatted-string");
    private final By confirmDeletePlayListButton = By.xpath("//yt-button-renderer[2]//yt-formatted-string");
    private final By deletePlayListButtonWhenThereIsVideo = By.xpath("//ytd-menu-service-item-renderer[5]//yt-formatted-string");

    public void clickKebabMenu(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(kebabMenu).click();
    }

    public void clickDeletePlayListButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(deletePlaylistButton));
        driver.findElement(deletePlaylistButton).click();
    }

    public void clickDeletePlayListButtonWhenThereIsVideo(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(deletePlayListButtonWhenThereIsVideo));
        driver.findElement(deletePlayListButtonWhenThereIsVideo).click();

    }


    public void clickConfirmDeletePlayListButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(confirmDeletePlayListButton).click();
    }

    public YoutubePlayListPage(WebDriver driver) {
        this.driver = driver;
    }
}
