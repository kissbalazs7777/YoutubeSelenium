package profileSettings;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.YoutubeAccountPage;
import pages.YoutubeHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileSettingsTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
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
        youtubeHomePage.clickAvatarButton();
        YoutubeAccountPage youtubeAccountPage = youtubeHomePage.clickSettings();
        assertEquals("ijfutrabanttesztelok@gmail.com", youtubeAccountPage.getTextFromSpan());
    }

    @Test
    public void testLogOut(){
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
        youtubeHomePage.clickAvatarButton();
        HomePage youtubeHomePageAfterLogOut = youtubeHomePage.clickLogOutButton();
        assertTrue(youtubeHomePageAfterLogOut.getLoginButton() > 0);
    }

}
