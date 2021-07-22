package profileSettings;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.LogInPage;
import pages.YoutubeAccountPage;
import pages.YoutubeHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileSettingsTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.clickAvatarButton();
        YoutubeAccountPage youtubeAccountPage = youtubeHomePage.clickSettings();
        assertEquals("ladatolcsontesztelek@gmail.com", youtubeAccountPage.getTextFromSpan());
    }

    @Test
    public void testLogOut() {
        homePage.typeEmail(email);
        homePage.clickNextButton();
        homePage.typePassword(pw);
        YoutubeHomePage youtubeHomePage = homePage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        youtubeHomePage.clickLanguageSettings();
        youtubeHomePage.clickHuOption();
        youtubeHomePage.clickAvatarButton();
        LogInPage logInPage = youtubeHomePage.clickLogOutButton();
        assertTrue(logInPage.isLoginButtonVisible());
    }

}
