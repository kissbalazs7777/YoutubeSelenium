package channel;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ChannelTest extends BaseTests {

    @Test
    public void testSubscribeChannel(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.clickSubscribeButton();
        assertTrue(youtubeVideoPage.isSubscribedMessageShowedUp());
    }

    @Test
    public void testUnSubscribeChannel(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.clickSubscribeButton();
        youtubeVideoPage.clickSubscribeButton();
        youtubeVideoPage.clickConfirmUnSubscribeButton();
        assertTrue(youtubeVideoPage.isUnSubscribedMessageShowedUp());
    }



}
