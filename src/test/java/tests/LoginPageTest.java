package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateToLoginPage();
        String actLoginPageTitle = loginPage.getLoginPageTitle();
        System.out.println("Page act Title : " + actLoginPageTitle);
        Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @Test(priority = 3)
    public void appLoginTest() {
        String userName = prop.getProperty("username").trim();
        String password = prop.getProperty("password").trim();
        Assert.assertTrue( loginPage.doLogin(userName, password));
    }

}
