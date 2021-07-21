package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YoutubeSearchHistoryPage {

    private WebDriver driver;
    private final By searchInput = By.xpath("//input[@name='query']");
    private final By searchIcon = By.xpath("//button[@aria-label='Keresés a megtekintési előzményekben']");
    private final By removeFromHistoryButton = By.xpath("//button[@aria-label='Eltávolítás innen: Korábbi megtekintések']");
    private final By removedFromHistoryMsg = By.xpath("//yt-formatted-string[@aria-label='A videó összes megtekintését eltávolítottuk az előzményekből']");

    public void clickSearchInput(){
        driver.findElement(searchInput).click();
    }

    public void typeInSearchInput(String keyWord){
        driver.findElement(searchInput).sendKeys(keyWord);
    }

    public void clickSearchIcon(){
        driver.findElement(searchIcon).click();
    }

    public String getCurrentQuearyInUrl(){
        return driver.getCurrentUrl();
    }

    public void clickRemoveFromHistoryButton(){
        driver.findElement(removeFromHistoryButton).click();
    }

    public boolean isRemovedFromHistoryMsgShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(removedFromHistoryMsg));
            driver.findElement(removedFromHistoryMsg);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public YoutubeSearchHistoryPage(WebDriver driver) {
        this.driver = driver;
    }
}
