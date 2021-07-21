package playlist;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistTests extends BaseTests {

    @Test
    public void createPlaylist() throws InterruptedException {
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
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreateNewPlaylistButton();
        youtubeVideoPage.clickTypePlaylistNameInput();
        youtubeVideoPage.typeIntoPlaylistNameInput("Traktor2");
        youtubeVideoPage.clickConfirmCreatePlaylistButton();
        assertTrue(youtubeVideoPage.isPlayListCreatedMessageShowedUp());
    }

    @Test
    public void removePlaylist() throws InterruptedException {
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

        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreateNewPlaylistButton();
        youtubeVideoPage.clickTypePlaylistNameInput();
        youtubeVideoPage.typeIntoPlaylistNameInput("Traktor2");
        youtubeVideoPage.clickConfirmCreatePlaylistButton();
        youtubeVideoPage.waitUntilPlaylistCreatedMsgDisappear();

        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreatedPlayList();
        assertTrue(youtubeVideoPage.isRemovedFromPlayListMessageShowedUp());
        Thread.sleep(10000);
    }

    @Test
    public void addPlaylist() throws InterruptedException {
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

        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreateNewPlaylistButton();
        youtubeVideoPage.clickTypePlaylistNameInput();
        youtubeVideoPage.typeIntoPlaylistNameInput("Traktor2");
        youtubeVideoPage.clickConfirmCreatePlaylistButton();
        youtubeVideoPage.isPlayListCreatedMessageShowedUp();
        youtubeVideoPage.waitUntilPlaylistCreatedMsgDisappear();

        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreatedPlayList();

        youtubeVideoPage.waitUntilFromPlaylistRemovedMsgDisappear();
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreatedPlayList();

    }

}
