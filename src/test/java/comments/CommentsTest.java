package comments;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.YoutubeHomePage;
import pages.YoutubeSearchResultsPage;
import pages.YoutubeVideoPage;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentsTest extends BaseTests {

    @Test
    public void testWriteComment() throws InterruptedException {
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
        Utils.scrollDown(getDriver());
        youtubeVideoPage.clickInput();
        youtubeVideoPage.writeIntoCommentInputField("Idős anyám is mívelte");
        youtubeVideoPage.makeSubmitButtonClickable("Disabled");
        youtubeVideoPage.clickSubmitCommentButton();
        assertTrue(youtubeVideoPage.isCommentShowedUp());
    }

    @Test
    public void editComment() throws InterruptedException {
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
