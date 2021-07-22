package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YoutubeVideoPage {

    private WebDriver driver;
    private final By logo = By.xpath("//yt-icon[@id='logo-icon']");
    private final By adInfoButton = By.xpath("//*[contains(@id, 'ad-info-hover-text-button')]");
    private final By skipAdButton = By.xpath("//*[@class='ytp-ad-skip-button ytp-button']");
    private final By stopOrStartVideoButton = By.xpath("//button[@class='ytp-play-button ytp-button']");
    private final By fullScreenButton = By.xpath("//button[@class='ytp-fullscreen-button ytp-button']");
    private final By settingsButton = By.xpath("//button[@data-tooltip-target-id='ytp-settings-button']");
    private final By commentaryButton = By.xpath("//div[text()='Kommentárok']");
    private final By menuItemCheckBox = By.xpath("//div[@role='menuitemcheckbox']");
    private final By changeSpeedButton = By.xpath("//div[text()='Lejátszási sebesség']");
    private final By speed2xButton = By.xpath("//*[text()='2']");
    private final By currentSpeed = By.xpath("//*[text()='2']");
    private final By changeQualityButton = By.xpath("//*[text()='Minőség']");
    private final By quality360pButton = By.xpath("//*[text()='360p']");
    private final By currentQuality = By.xpath("//span[text()='360p']");
    private final By likeIcon = By.xpath("//div[3]/div/ytd-menu-renderer/div/ytd-toggle-button-renderer[1]/a/yt-icon-button/button/yt-icon");
    private final By likeButtonElement = By.xpath("//div[3]/div/ytd-menu-renderer/div/ytd-toggle-button-renderer[1]/a/yt-icon-button/button");
    private final By disLikeIcon = By.xpath("//div[3]/div/ytd-menu-renderer/div/ytd-toggle-button-renderer[2]/a/yt-icon-button/button/yt-icon");
    private final By disLikeButtonElement = By.xpath("//div[3]/div/ytd-menu-renderer/div/ytd-toggle-button-renderer[2]/a/yt-icon-button/button");
    private final By subscribeButton = By.xpath("//ytd-video-secondary-info-renderer/div/div/div/ytd-subscribe-button-renderer/tp-yt-paper-button");
    private final By subscribedMessage = By.xpath("//*[text()='Feliratkozás hozzáadva']");
    private final By confirmUnSubscribeButton = By.xpath("//yt-formatted-string[text()='Leiratkozás']");
    private final By unSubscribedMessage = By.xpath("//*[text()='Feliratkozás eltávolítva']");
    private final By commentInputField = By.xpath("//*[contains(text(), 'Írj nyilvános hozzászólást...')]");
    private final By submitCommentButton = By.xpath("//*[@id='submit-button']");
    private final By comment = By.xpath("//yt-formatted-string[text()='Idős anyám is mívelte']");
    private final By editCommentKebabMenu = By.xpath("//ytd-comment-thread-renderer[1]/ytd-comment-renderer/div[2]/div[3]/ytd-menu-renderer/yt-icon-button/button/yt-icon");
    private final By editCommentButton = By.xpath("//yt-formatted-string[text()='Szerkesztés']");
    private final By saveEditedCommentButton = By.xpath("//ytd-comment-renderer/div[3]/ytd-comment-dialog-renderer/ytd-commentbox/div/div[4]/div[5]/ytd-button-renderer[2]");
    private final By editedComment = By.xpath("//yt-formatted-string[text()='Idős anyám is mívelte!!!!!!!!!!!!!!!!!!!!!!']");
    private final By savePlayListButton = By.xpath("//div[3]/div/ytd-menu-renderer/div/ytd-button-renderer[2]/a/yt-icon-button/button/yt-icon");
    private final By createNewPlaylistButton = By.xpath("//yt-formatted-string[text()='Új lejátszási lista létrehozása']");
    private final By typePlaylistNameInput = By.xpath("//input[@placeholder='Add meg a lejátszási lista nevét...']");
    private final By confirmCreatePlaylistButton = By.xpath("//yt-formatted-string[text()='Létrehozás']");
    private final By playListCreatedMessage = By.xpath("//tp-yt-paper-toast/div/yt-formatted-string[1]/span[1]");
    private final By createdPlayList = By.xpath("//yt-formatted-string[@title='Traktor2']");
    private final By removedFromPlaylistMessage = By.xpath("//tp-yt-paper-toast/div/yt-formatted-string[1]/span[1]");
    private final By closePlaylistWindowButton = By.xpath("//ytd-add-to-playlist-renderer/div[1]/yt-icon-button/button");
    private final By deleteCommentButton = By.xpath("//ytd-menu-navigation-item-renderer[2]/a/tp-yt-paper-item/yt-icon");
    private final By confirmDeleteButton = By.xpath("//yt-button-renderer[@id='confirm-button']");
    private final By commentDeletedMsg = By.xpath("//tp-yt-paper-toast//yt-formatted-string[1]");
    private final By submittedComment = By.xpath("//ytd-item-section-renderer[@id='sections']//*[text()='Idős anyám is mívelte']");

    public WebDriver getDriver() {
        return driver;
    }

    public void handleVideoAds(){
        try{
            driver.findElement(adInfoButton);
            System.out.println("Van ad");
            try{
                WebDriverWait wait = new WebDriverWait(driver, 6);
                wait.until(ExpectedConditions.visibilityOfElementLocated(skipAdButton));
                driver.findElement(skipAdButton).click();
                System.out.println("Skippable ad");
            }catch (Exception e){
                WebDriverWait waitNonSkippAbleAd = new WebDriverWait(driver, 60);
                waitNonSkippAbleAd.until(ExpectedConditions.numberOfElementsToBe(adInfoButton, 0));
                System.out.println("Non skipable ad átugorva!");
            }
        }catch (Exception ignored){
            System.out.println("Nincs ad");
        }
    }

    public boolean isThereVideoManagingButton(){
        return !driver.findElement(stopOrStartVideoButton).getCssValue("height").equals("100%");
    }

    public void clickVideoManagingButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(stopOrStartVideoButton).click();
    }

    public String getWhetherStartOrStopVideoButton(){
        return driver.findElement(stopOrStartVideoButton).getAttribute("aria-label");
    }

    public void clickFullScreenButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(fullScreenButton).click();
    }

    public String getFullScreenButtonTitle(){
        return driver.findElement(fullScreenButton).getAttribute("title");
    }

    public void clickSettingsButton(){
        driver.findElement(settingsButton).click();
    }

    public void clickCommentaryButton(){
        driver.findElement(commentaryButton).click();
    }

    public String getMenuItemCheckBoxState(){
        return driver.findElement(menuItemCheckBox).getAttribute("aria-checked");
    }

    public void clickChangeSpeedButton(){
        driver.findElement(changeSpeedButton).click();
    }

    public void click2xSpeedChangeButton(){
        driver.findElement(speed2xButton).click();
    }

    public String getSpeed(){
        return driver.findElement(currentSpeed).getText();
    }

    public void clickChangeQualityButton(){
        driver.findElement(changeQualityButton).click();
    }

    public void click360pQualityChangeButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(quality360pButton));
        driver.findElement(quality360pButton).click();
    }

    public String getQuality(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(currentQuality).getText();
    }

    public void clickLikeButton(){
        driver.findElement(likeIcon).click();
    }

    public String getLikeButtonState(){
        return driver.findElement(likeButtonElement).getAttribute("aria-pressed");
    }

    public void clickDisLikeButton(){
        driver.findElement(disLikeIcon).click();
    }

    public String getDisLikeButtonState(){
        return driver.findElement(disLikeButtonElement).getAttribute("aria-pressed");
    }

    public void clickSubscribeButton(){
        driver.findElement(subscribeButton).click();
    }

    public boolean isSubscribedMessageShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(subscribedMessage));
            driver.findElement(subscribedMessage);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void clickConfirmUnSubscribeButton(){
        driver.findElement(confirmUnSubscribeButton).click();
    }

    public boolean isUnSubscribedMessageShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(unSubscribedMessage));
            driver.findElement(unSubscribedMessage);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void clickInput(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(commentInputField).click();
    }

    public void writeIntoCommentInputField(String innerHtml){
        System.out.println(innerHtml);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('contenteditable-root').innerHTML = '" + innerHtml + "'");
    }

    public void writeIntoEditCommentInputField(String innerHtml){
        System.out.println(innerHtml);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('#contenteditable-root')[1].innerHTML = '" + innerHtml + "'");
    }

    public void scrollDown() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
    }

    public void makeSubmitButtonClickable(String attribute){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('submit-button').removeAttribute('"+ attribute +"')");
    }

    public void makeSaveButtonClickable(String attribute){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('#submit-button')[1].removeAttribute('"+ attribute +"')");
    }

    public void clickSubmitCommentButton(){
        driver.findElement(submitCommentButton).click();
    }

    public boolean isCommentShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(comment));
            driver.findElement(comment);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void clickKebabMenu(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(editCommentKebabMenu).click();
    }

    public void clickEditCommentButton(){
        driver.findElement(editCommentButton).click();
    }

    public void clickSaveEditedCommentButton(){
        driver.findElement(saveEditedCommentButton).click();
    }

    public boolean isEditedCommentShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(editedComment));
            driver.findElement(editedComment);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void clickSavePlaylistButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(savePlayListButton).click();
    }

    public void clickCreateNewPlaylistButton(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(createNewPlaylistButton));
        driver.findElement(createNewPlaylistButton).click();
    }

    public void clickTypePlaylistNameInput(){
        driver.findElement(typePlaylistNameInput);
    }

    public void typeIntoPlaylistNameInput(String name){
        driver.findElement(typePlaylistNameInput).sendKeys(name);
    }

    public void clickConfirmCreatePlaylistButton(){
        driver.findElement(confirmCreatePlaylistButton).click();
    }

    public boolean isPlayListCreatedMessageShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(playListCreatedMessage));
            driver.findElement(playListCreatedMessage);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void clickCreatedPlayList(){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createdPlayList));
        driver.findElement(createdPlayList).click();
    }

    public boolean isRemovedFromPlayListMessageShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(removedFromPlaylistMessage));
            driver.findElement(removedFromPlaylistMessage);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void waitUntilPlaylistCreatedMsgDisappear(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(playListCreatedMessage));
            driver.findElement(playListCreatedMessage);
        }catch (Exception ignored){

        }
    }

    public void waitUntilFromPlaylistRemovedMsgDisappear(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(removedFromPlaylistMessage));
            driver.findElement(removedFromPlaylistMessage);
        }catch (Exception ignored){

        }
    }

    public void clickClosePlaylistWindowButton(){
        driver.findElement(closePlaylistWindowButton).click();
    }

    public void clicklogo(){
        driver.findElement(logo).click();
    }

    public void clickDeleteCommentButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(deleteCommentButton).click();
    }

    public void clickConfirmDeleteButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(confirmDeleteButton).click();
    }

    public boolean isCommentDeletedMsgShowedUp(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(commentDeletedMsg));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void waitUntilCommentShowsUp(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(submittedComment));
        }catch (Exception e){
            System.out.println("Comment is not submitted");
        }
    }

    public YoutubeVideoPage(WebDriver driver) {
        this.driver = driver;
    }
}
