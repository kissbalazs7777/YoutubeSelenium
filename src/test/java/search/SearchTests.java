package search;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTests extends BaseTests {

    @Test
    public void testSearchWrittenCriteria() throws InterruptedException {
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
        youtubeHomePage.clickWrittenCriteria();
        assertEquals("rgba(0, 0, 0, 0)", youtubeHomePage.getWrittenCriteriaColor());
    }

    @Test
    public void testSearchVideoWithSearchHistory() throws InterruptedException {
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
        YoutubeSearchHistoryPage youtubeSearchHistoryPage = youtubeHomePage.clickSearchHistoryButton();
        youtubeSearchHistoryPage.clickSearchInput();
        youtubeSearchHistoryPage.typeInSearchInput("gopro");
        youtubeSearchHistoryPage.clickSearchIcon();
        assertEquals("https://www.youtube.com/feed/history?query=gopro", youtubeSearchHistoryPage.getCurrentQuearyInUrl());
    }

    @Test
    public void testRemoveItemFromSearchHistory() throws InterruptedException {
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
        youtubeVideoPage.clicklogo();

        Utils.refresh(getDriver());

        YoutubeSearchHistoryPage youtubeSearchHistoryPage = youtubeHomePage.clickSearchHistoryButton();
        youtubeSearchHistoryPage.clickRemoveFromHistoryButton();
        assertTrue(youtubeSearchHistoryPage.isRemovedFromHistoryMsgShowedUp());
    }

}
