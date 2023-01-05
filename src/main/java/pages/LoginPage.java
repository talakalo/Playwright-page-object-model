package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private String emailId = "#input-email";
    private String passwordId = "#input-password";
    private String forgotPwdLink = "a:text('Forgotten Password')";
    private String loginBtn = "input[value='Login']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdLinkExist() {
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String userName, String password) {

        System.out.printf("App creds: " + userName + ": " + password);
        page.fill(emailId, userName);
        page.fill(passwordId, password);
        page.click(loginBtn);
        page.locator(logoutLink).waitFor();
        if (page.locator(logoutLink).isVisible()) {
            System.out.println("user is logged in successfully");
            return true;
        }else {
            System.out.println("user is not logged in successfully");
            return false;
        }

    }
}
