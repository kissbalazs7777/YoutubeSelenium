package comments;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentsTest extends BaseTests {

    @Test
    public void testWriteComment() {
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
        youtubeVideoPage.clickInput();
        youtubeVideoPage.writeIntoCommentInputField("Idős anyám is mívelte");
        youtubeVideoPage.makeSubmitButtonClickable("Disabled");
        youtubeVideoPage.clickSubmitCommentButton();
        assertTrue(youtubeVideoPage.isCommentShowedUp());
        //restore original state
        youtubeVideoPage.waitUntilCommentShowsUp();
        youtubeVideoPage.clickKebabMenu();
        youtubeVideoPage.clickDeleteCommentButton();
        youtubeVideoPage.clickConfirmDeleteButton();

    }

    @Test
    public void editComment() {
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
        youtubeVideoPage.clickInput();
        youtubeVideoPage.writeIntoCommentInputField("Idős anyám is mívelte");
        youtubeVideoPage.makeSubmitButtonClickable("Disabled");
        youtubeVideoPage.clickSubmitCommentButton();
        youtubeVideoPage.waitUntilCommentShowsUp();
        youtubeVideoPage.clickKebabMenu();
        youtubeVideoPage.clickEditCommentButton();
        youtubeVideoPage.writeIntoEditCommentInputField("Idős anyám is mívelte!!!!!!!!!!!!!!!!!!!!!!");
        youtubeVideoPage.makeSaveButtonClickable("Disabled");
        youtubeVideoPage.clickSaveEditedCommentButton();
        assertTrue(youtubeVideoPage.isEditedCommentShowedUp());
        //restore original state
        youtubeVideoPage.waitUntilCommentShowsUp();
        youtubeVideoPage.clickKebabMenu();
        youtubeVideoPage.clickDeleteCommentButton();
        youtubeVideoPage.clickConfirmDeleteButton();
    }

    @Test
    public void testDeleteComment() { ;
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
        youtubeVideoPage.clickInput();
        youtubeVideoPage.writeIntoCommentInputField("Idős anyám is mívelte");
        youtubeVideoPage.makeSubmitButtonClickable("Disabled");
        youtubeVideoPage.clickSubmitCommentButton();
        youtubeVideoPage.waitUntilCommentShowsUp();
        youtubeVideoPage.clickKebabMenu();
        youtubeVideoPage.clickDeleteCommentButton();
        youtubeVideoPage.clickConfirmDeleteButton();
        assertTrue(youtubeVideoPage.isCommentDeletedMsgShowedUp());
    }
}
