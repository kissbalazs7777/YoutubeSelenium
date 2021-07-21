package playlist;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistTests extends BaseTests {

    @Test
    public void createPlaylist(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
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
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
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
    public void addPlaylist() {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
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
