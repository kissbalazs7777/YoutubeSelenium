package search;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTests extends BaseTests {

    @Test
    public void testSearchWrittenCriteria(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
        youtubeHomePage.clickWrittenCriteria();
        assertEquals("rgba(0, 0, 0, 0)", youtubeHomePage.getWrittenCriteriaColor());
    }

    @Test
    public void testSearchVideoWithSearchHistory(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
        YoutubeSearchHistoryPage youtubeSearchHistoryPage = youtubeHomePage.clickSearchHistoryButton();
        youtubeSearchHistoryPage.clickSearchInput();
        youtubeSearchHistoryPage.typeInSearchInput("gopro");
        youtubeSearchHistoryPage.clickSearchIcon();
        assertEquals("https://www.youtube.com/feed/history?query=gopro", youtubeSearchHistoryPage.getCurrentQuearyInUrl());
    }

    @Test
    public void testRemoveItemFromSearchHistory(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
        youtubeHomePage.typeInSearchField("GoPro: Tractor Drift");
        YoutubeSearchResultsPage youtubeSearchResultsPage = youtubeHomePage.clickSearchIcon();
        YoutubeVideoPage youtubeVideoPage = youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.clicklogo();

        Utils.refresh(getDriver());

        YoutubeSearchHistoryPage youtubeSearchHistoryPage = youtubeHomePage.clickSearchHistoryButton();
        youtubeSearchHistoryPage.clickRemoveFromHistoryButton();
        assertTrue(youtubeSearchHistoryPage.isRemovedFromHistoryMsgShowedUp());
    }

}
