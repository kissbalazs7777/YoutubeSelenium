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
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        YoutubeAccountPage youtubeAccountPage = youtubeHomePage.clickSettings();
        assertEquals("ijfutrabanttesztelok@gmail.com", youtubeAccountPage.getTextFromSpan());
    }

    @Test
    public void testLogOut(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeEmail("ladatolcsontesztelek@gmail.com");
        loginPage.clickNextButton();
        loginPage.typePassword("QA123456");
        YoutubeHomePage youtubeHomePage = loginPage.clickSubmitButton();
        youtubeHomePage.clickAvatarButton();
        HomePage youtubeHomePageAfterLogOut = youtubeHomePage.clickLogOutButton();
        assertTrue(youtubeHomePageAfterLogOut.getLoginButton() > 0);
    }

}
