package comments;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentsTest extends BaseTests {

    @Test
    public void testWriteComment() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.clickLanguageSettings();
        loginPage.clickHuOption();
        loginPage.typeEmail(email);
        loginPage.clickNextButton();
        loginPage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
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
    }

    @Test
    public void editComment() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.clickLanguageSettings();
        loginPage.clickHuOption();
        loginPage.typeEmail(email);
        loginPage.clickNextButton();
        loginPage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
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
        youtubeVideoPage.clickKebabMenu();
        youtubeVideoPage.clickEditCommentButton();
        youtubeVideoPage.writeIntoEditCommentInputField("Idős anyám is mívelte!!!!!!!!!!!!!!!!!!!!!!");
        youtubeVideoPage.makeSubmitButtonClickable("Disabled");
        youtubeVideoPage.clickSaveEditedCommentButton();
        assertTrue(youtubeVideoPage.isEditedCommentShowedUp());
    }

}
