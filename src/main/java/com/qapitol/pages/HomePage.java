package com.qapitol.pages;

import com.qapitol.sauron.core.pages.AbstractPage;
import com.qapitol.sauron.web.WebActionListener;

public class HomePage extends AbstractPage implements WebActionListener {

  public static final String PROFILE_ICON = "profileIcon";
  public static final String PROFILE_PAGE = "profile";

  public void clickOnProfileIcon() {
    waitAndClickOn(PROFILE_ICON);
  }

  public void clickOnProfileButton() {
    waitAndClickOn(PROFILE_PAGE);
  }

}
