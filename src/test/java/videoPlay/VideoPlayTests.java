package videoPlay;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoPlayTests extends BaseTests {

    @Test
    public void testNavigateToVideo() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        System.out.println(youtubeHomePage.getUrl());
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
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        assertEquals("Lejátszás (k)" ,youtubeVideoPage.getWhetherStartOrStopVideoButton());
    }

    @Test
    public void testStartActions() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickVideoManagingButton();
        assertEquals("Szüneteltetés (k)" ,youtubeVideoPage.getWhetherStartOrStopVideoButton());
    }

    @Test
    public void testFullScreen() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.handleVideoAds();
        youtubeVideoPage.clickVideoManagingButton();
        youtubeVideoPage.clickFullScreenButton();
        assertEquals("Kilépés a teljes képernyőből (f)" ,youtubeVideoPage.getFullScreenButtonTitle());
    }

    @Test
    public void testCommentarySettings() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
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
    public void testSpeed() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
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
    public void testQuality() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
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
    public void testLikeVideo() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
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
    }

    @Test
    public void testDisLikeVideo() throws InterruptedException {
        homePage.clickLanguageSettings();
        homePage.clickHuOption();
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        Thread.sleep(2000);
        System.out.println(youtubeHomePage.getUrl());
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
    }

}
