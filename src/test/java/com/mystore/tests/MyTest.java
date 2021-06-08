package com.mystore.tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class MyTest extends BaseTest {
  private static final String WELCOME_TEXT =
      "Welcome to the Secure Area. When you are done click logout below.";

  @Step
  @Test
  public void loginTest() {
    app.loginPage.open();
    logger.info("loginTest start");
    app.loginPage.login("tomsmith", "SuperSecretPassword!");
    softAssert.assertEquals(app.loginPage.getWelcomeText(), WELCOME_TEXT);
  }

  @Step
  @Test
  public void deleteButtonTest() {
    app.addAndRemovePage.open();
    logger.info("deleteButtonTest start");
    app.addAndRemovePage.clickOnAddButton(3);
    app.addAndRemovePage.clickOnDeleteButton();
    softAssert.assertEquals(app.addAndRemovePage.getDeleteElementsSize(), 0);
  }
}
