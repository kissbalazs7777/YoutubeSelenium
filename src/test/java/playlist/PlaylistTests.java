package playlist;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistTests extends BaseTests {

    @Test
    public void createPlaylist() {
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
        Utils.scrollDown(getDriver());
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreateNewPlaylistButton();
        youtubeVideoPage.clickTypePlaylistNameInput();
        youtubeVideoPage.typeIntoPlaylistNameInput("Traktor2");
        youtubeVideoPage.clickConfirmCreatePlaylistButton();
        assertTrue(youtubeVideoPage.isPlayListCreatedMessageShowedUp());
        //restore original state
        youtubeVideoPage.clickAvatarButton();
        YoutubeStudioPage youtubeStudioPage = youtubeVideoPage.clickYoutubeStudio();
        youtubeStudioPage.clickPlayListButton();
        YoutubePlayListPage youtubePlayListPage = youtubeStudioPage.clickPlayListRow();
        youtubePlayListPage.clickKebabMenu();
        youtubePlayListPage.clickDeletePlayListButtonWhenThereIsVideo();
        youtubePlayListPage.clickConfirmDeletePlayListButton();
    }

    @Test
    public void removePlaylist() throws InterruptedException {
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
        Utils.scrollDown(getDriver());
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreateNewPlaylistButton();
        youtubeVideoPage.clickTypePlaylistNameInput();
        youtubeVideoPage.typeIntoPlaylistNameInput("Traktor2");
        youtubeVideoPage.clickConfirmCreatePlaylistButton();
        youtubeVideoPage.waitUntilPlaylistCreatedMsgDisappear();
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreatedPlayList();
        youtubeVideoPage.clickClosePlaylistWindowButton();
        assertTrue(youtubeVideoPage.isRemovedFromPlayListMessageShowedUp());
        //restore original state
        youtubeVideoPage.clickAvatarButton();
        YoutubeStudioPage youtubeStudioPage = youtubeVideoPage.clickYoutubeStudio();
        youtubeStudioPage.clickPlayListButton();
        YoutubePlayListPage youtubePlayListPage = youtubeStudioPage.clickPlayListRow();
        youtubePlayListPage.clickKebabMenu();
        youtubePlayListPage.clickDeletePlayListButton();
        youtubePlayListPage.clickConfirmDeletePlayListButton();
    }

    @Test
    public void addPlaylist() throws InterruptedException {
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
        Utils.scrollDown(getDriver());
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreateNewPlaylistButton();
        youtubeVideoPage.clickTypePlaylistNameInput();
        youtubeVideoPage.typeIntoPlaylistNameInput("Traktor2");
        youtubeVideoPage.clickConfirmCreatePlaylistButton();
        youtubeVideoPage.waitUntilPlaylistCreatedMsgDisappear();
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreatedPlayList();
        youtubeVideoPage.clickClosePlaylistWindowButton();
        youtubeVideoPage.isRemovedFromPlayListMessageShowedUp();

        youtubeVideoPage.clicklogo();
        Utils.refresh(getDriver());
        youtubeHomePage.typeInSearchField("tractor con motor volvo");
        youtubeHomePage.clickSearchIcon();
        youtubeSearchResultsPage.clickFirstResult();
        youtubeVideoPage.clickSavePlaylistButton();
        youtubeVideoPage.clickCreatedPlayList();
        youtubeVideoPage.clickClosePlaylistWindowButton();
        assertTrue(youtubeVideoPage.isAddedToPlayListMessageShowedUp());

        //restore original state
        youtubeVideoPage.clickAvatarButton();
        YoutubeStudioPage youtubeStudioPage = youtubeVideoPage.clickYoutubeStudio();
        youtubeStudioPage.clickPlayListButton();
        YoutubePlayListPage youtubePlayListPage = youtubeStudioPage.clickPlayListRow();
        youtubePlayListPage.clickKebabMenu();
        youtubePlayListPage.clickDeletePlayListButtonWhenThereIsVideo();
        youtubePlayListPage.clickConfirmDeletePlayListButton();
    }

}
