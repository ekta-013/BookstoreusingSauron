package com.qapitol.pages;

import com.qapitol.sauron.common.configuration.Config;
import com.qapitol.sauron.core.Grid;
import com.qapitol.sauron.core.pages.AbstractPage;
import com.qapitol.sauron.report.core.annotations.ReportTestStep;
import com.qapitol.sauron.web.WebActionListener;
import java.util.List;
import org.openqa.selenium.devtools.v109.browser.model.PermissionType;
import org.testng.Assert;

public class LoginPage extends AbstractPage implements WebActionListener {

  public static final String EMAIL = "email";
  public static final String PASSWORD = "password";
  public static final String CART_BUTTON = "cartBtn";
  public static final String SUBMIT_BUTTON = "submitButton";
  private static final String MIC = "mic";
  public static final String URL = "url";
  private static final String GOOGLE_URL = "https://www.google.com/";

  public static final String SIGN_IN_BUTTON = "signBtn";

  @ReportTestStep("launch book store web application")
  public void browserLaunchBookStore() {
    Grid.driver().get(Config.getConfigProperty(URL));
  }

  public void browserLaunchGoogle() {
    Grid.driver().get(GOOGLE_URL);
  }

  @ReportTestStep("login to book store web application")
  public void loginIntoPage() {
    Assert.assertTrue(waitAndCheckIsElementPresent(SIGN_IN_BUTTON));
    waitAndClickOn(SIGN_IN_BUTTON);
    Assert.assertTrue(waitAndCheckIsElementPresent(EMAIL));
    Assert.assertTrue(waitAndCheckIsElementPresent(PASSWORD));
    clearTextBox(EMAIL);
    waitAndSetText(EMAIL, Config.getConfigProperty(EMAIL));
    clearTextBox(PASSWORD);
    waitAndSetText(PASSWORD, Config.getConfigProperty(PASSWORD));
    Assert.assertTrue(waitAndCheckIsElementPresent(SUBMIT_BUTTON));
    waitAndClickOn(SUBMIT_BUTTON);
  }

  @ReportTestStep("verify is logged into book store application")
  public void verifyUserLoggedInToApp() {
    Assert.assertTrue(waitAndCheckIsElementPresent(CART_BUTTON));
  }

  @ReportTestStep("navigate back to home page")
  public void verifyUserIsNavigateBackToHomePage() {
    clickOnBack();
    Assert.assertTrue(waitAndCheckIsElementPresent(CART_BUTTON));
  }

  @ReportTestStep("allow browser notification to receive notifications")
  public void verifyBrowserGrantPermNotificationsViaCDP() {
    browserGrantPermNotificationsViaCDP();
  }

  @ReportTestStep("allow browser to access geolocation, video capture, audio capture")
  public void passingSelectedPermissionToGrantPermsViaCDP() {
    List<PermissionType> permissionTypes = List.of(PermissionType.GEOLOCATION,
        PermissionType.NOTIFICATIONS, PermissionType.VIDEOCAPTURE, PermissionType.AUDIOCAPTURE);
    browserGrantPermsViaCDP(permissionTypes);
    waitAndClickOn(MIC);
  }
}

