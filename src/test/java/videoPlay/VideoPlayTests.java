package videoPlay;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoPlayTests extends BaseTests {

    @Test
    public void testNavigateToVideo() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        assertTrue(youtubeVideoPage.isThereVideoManagingButton());
    }

    @Test
    public void testStopActions() throws InterruptedException {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        double stopTime = youtubeVideoPage.getProgressBarWhenPaused();
        Utils.waitForXMillis(2000);
        double currentTime = youtubeVideoPage.getProgressBarWhenPaused();
        assertEquals(stopTime, currentTime);
    }

    @Test
    public void testStartActions() throws InterruptedException {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        double stopTime = youtubeVideoPage.getProgressBarWhenPaused();
        youtubeVideoPage.clickVideoManagingButton();
        Utils.waitForXMillis(2000);
        double currentTime = youtubeVideoPage.getProgressBarWhenPaused();
        assertTrue(currentTime > stopTime);
    }

    @Test
    public void testFullScreen() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickFullScreenButton();
        assertTrue(youtubeVideoPage.hasFullscreenAttrWatchFlexy());
    }

    @Test
    public void testCommentarySettings() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickSettingsButton();
        youtubeVideoPage.clickCommentaryButton();
        assertEquals("false" ,youtubeVideoPage.getMenuItemCheckBoxState());
    }

    @Test
    public void testSpeed() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickSettingsButton();
        youtubeVideoPage.clickChangeSpeedButton();
        youtubeVideoPage.click2xSpeedChangeButton();
        youtubeVideoPage.clickSettingsButton();
        youtubeVideoPage.clickSettingsButton();
        assertEquals("2", youtubeVideoPage.getSpeed());
    }

    @Test
    public void testQuality() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickSettingsButton();
        youtubeVideoPage.clickChangeQualityButton();
        youtubeVideoPage.click360pQualityChangeButton();
        youtubeVideoPage.clickSettingsButton();
        youtubeVideoPage.clickSettingsButton();
        assertEquals("360p", youtubeVideoPage.getQuality());
    }

    @Test
    public void testLikeVideo() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickLikeButton();
        assertEquals("true", youtubeVideoPage.getLikeButtonState());
        //restore original state
        youtubeVideoPage.clickLikeButton();
    }

    @Test
    public void testDisLikeVideo() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickLikeButton();
        youtubeVideoPage.clickDisLikeButton();
        assertEquals("true", youtubeVideoPage.getDisLikeButtonState());
        //restore original state
        youtubeVideoPage.clickDisLikeButton();
    }
}
