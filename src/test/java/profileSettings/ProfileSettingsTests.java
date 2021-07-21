package profileSettings;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.YoutubeAccountPage;
import pages.YoutubeHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileSettingsTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
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
        youtubeHomePage.clickAvatarButton();
        YoutubeAccountPage youtubeAccountPage = youtubeHomePage.clickSettings();
        assertEquals("ijfutrabanttesztelok@gmail.com", youtubeAccountPage.getTextFromSpan());
    }

    @Test
    public void testLogOut() throws InterruptedException {
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
        youtubeHomePage.clickAvatarButton();
        HomePage youtubeHomePageAfterLogOut = youtubeHomePage.clickLogOutButton();
        //assertTrue(youtubeHomePageAfterLogOut.getLoginButton() > 0);
    }

}
