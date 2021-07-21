package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YoutubeHomePage {

    private WebDriver driver;
    private final By avatarButton = By.xpath("//button/yt-img-shadow/img");
    private final By languageSettingButton = By.xpath("//yt-multi-page-menu-section-renderer[2]/div[2]/ytd-compact-link-renderer[1]/a");
    private final By huOptionFromLanguageSettings = By.xpath("//yt-formatted-string[text()='Magyar']");
    private final By settingsButton = By.xpath("//*[text()='Beállítások' and @id='label']");
    private final By logOutButton = By.xpath("//*[text()='Kijelentkezés']");
    private final By searchField = By.xpath("//input[@id='search']");
    private final By searchIcon = By.xpath("//button[@id='search-icon-legacy']/yt-icon");
    private final By writtenCriteria = By.xpath("//yt-chip-cloud-chip-renderer[4]/yt-formatted-string");
    private final By searchHistoryButton = By.xpath("//*[text()='Előzmények']");

    public void clickAvatarButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(avatarButton));
        driver.findElement(avatarButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(settingsButton));
    }

    public void clickLanguageSettings(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(languageSettingButton).click();
    }

    public void clickHuOption(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(huOptionFromLanguageSettings).click();
    }

    public YoutubeAccountPage clickSettings(){
        driver.findElement(settingsButton).click();
        return new YoutubeAccountPage(driver);
    }

    public HomePage clickLogOutButton(){
        driver.findElement(logOutButton).click();
        return new HomePage(driver);
    }

    public void typeInSearchField(String keyWord){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(keyWord);
    }

    public YoutubeSearchResultsPage clickSearchIcon(){
        driver.findElement(searchIcon).click();
        return new YoutubeSearchResultsPage(driver);
    }

    public void clickWrittenCriteria(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(writtenCriteria).click();
    }

    public String getWrittenCriteriaColor(){
        return driver.findElement(writtenCriteria).getCssValue("background-color");
    }

    public YoutubeSearchHistoryPage clickSearchHistoryButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(searchHistoryButton).click();
        return new YoutubeSearchHistoryPage(driver);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public YoutubeHomePage(WebDriver driver) {
        this.driver = driver;
    }
}
