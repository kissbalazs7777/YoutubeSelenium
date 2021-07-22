package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class YoutubeStudioPage {

    private WebDriver driver;
    private final By playListButton = By.xpath("//ytcp-animatable[2]/ul/li[3]");
    private final By playListRow = By.xpath("//div/ytcp-playlist-row/div/div[1]/div/a");

    public void clickPlayListButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(playListButton).click();
    }

    public YoutubePlayListPage clickPlayListRow(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(playListRow).click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new YoutubePlayListPage(driver);
    }

    public YoutubeStudioPage(WebDriver driver) {
        this.driver = driver;
    }
}
