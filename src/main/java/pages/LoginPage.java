package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private Locator emailId = page.locator("#input-email");
    private Locator passwordId =page.locator( "#input-password");
    private Locator forgotPwdLink =page.locator( "a:text('Forgotten Password11')");
    private Locator loginBtn = page.locator("input[value='Login']");
    private Locator logoutLink = page.locator("//a[@class='list-group-item'][normalize-space()='Logout']");

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdLinkExist() {
        return forgotPwdLink.isVisible();
    }

    public boolean doLogin(String userName, String password) {

        System.out.printf("App creds: " + userName + ": " + password);
        this.emailId.fill(userName);
        this.passwordId.fill(password);
        this.loginBtn.click();

        if (logoutLink.isVisible()) {
            System.out.println("user is logged in successfully");
            return true;
        }
        return false;
    }
}
