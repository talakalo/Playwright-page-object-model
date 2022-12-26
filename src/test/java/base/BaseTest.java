package base;

import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.initProp();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }
    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
