package com.qapitol;

import com.qapitol.sauron.common.annotations.SauronTest;
import com.qapitol.sauron.core.pages.DiService;
import com.qapitol.sauron.report.core.annotations.ReportTest;
import com.qapitol.pages.HomePage;
import com.qapitol.pages.LoginPage;
import org.testng.annotations.Test;


public class BookStoreTest {
    LoginPage loginPage = DiService.get(LoginPage.class);
    HomePage homePage = DiService.get(HomePage.class);

    @SauronTest
    @Test
    @ReportTest("verify user is able to login to application")
    public void verifyUserAbleToLoginToApplication() {
        loginPage.browserLaunchBookStore();
        loginPage.loginIntoPage();
        loginPage.verifyUserLoggedInToApp();
    }

    @SauronTest
    @Test
    @ReportTest("verify user is able to navigate back to home page from profile page")
    public void verifyUserIsAbleNavigateBackToHomePageFromProfilePage() {
        loginPage.browserLaunchBookStore();
        loginPage.loginIntoPage();
        loginPage.verifyUserLoggedInToApp();
        homePage.clickOnProfileIcon();
        homePage.clickOnProfileButton();
        loginPage.verifyUserIsNavigateBackToHomePage();
    }
}
