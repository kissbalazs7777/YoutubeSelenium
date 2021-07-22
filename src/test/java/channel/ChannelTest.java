package channel;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ChannelTest extends BaseTests {

    @Test
    public void testSubscribeChannel() {
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
        youtubeVideoPage.clickSubscribeButton();
        assertTrue(youtubeVideoPage.isSubscribedMessageShowedUp());
        //restore original state
        youtubeVideoPage.clickSubscribeButton();
        youtubeVideoPage.clickConfirmUnSubscribeButton();
    }

    @Test
    public void testUnSubscribeChannel() {
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
        youtubeVideoPage.clickSubscribeButton();
        youtubeVideoPage.clickSubscribeButton();
        youtubeVideoPage.clickConfirmUnSubscribeButton();
        assertTrue(youtubeVideoPage.isUnSubscribedMessageShowedUp());
    }



}
