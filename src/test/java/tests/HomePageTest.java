package tests;


import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest() {
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageUrlTest() {
        String expectedUrl =prop.getProperty("url");
        String actualUrl = homePage.getHomePageUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @DataProvider
    public Object[][] getProductData() {
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductData")
    public void searchTest(String productName) {
        String actualSearchHeader = homePage.doSearch(productName);

        Assert.assertEquals(actualSearchHeader, "Search - " + productName);
    }


}
