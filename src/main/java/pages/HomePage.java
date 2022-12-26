package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    //1. String Locators - OR

    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String loginLink = "a:text('Login')";
    private String accountLink = "a[title='My Account']";

    //2. HomePage constructor
    public HomePage(Page page) {
        this.page = page;
    }


    //3. page  actions/methods
    public String getHomePageTitle() {
        String title = page.title();
        System.out.printf("page title is  :" + title);
        return title;
    }


    public String getHomePageUrl() {
        String url = page.url();
        System.out.printf("page url is  :" + url);
        return url;
    }

    public String doSearch(String productName) {
        page.fill(search, productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.printf("page header is :" + header);
        return header;
    }


    public LoginPage navigateToLoginPage() {
        page.click(accountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }
}
