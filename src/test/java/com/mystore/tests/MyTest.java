package com.mystore.tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class MyTest extends BaseTest {
  private static final String WELCOME_TEXT =
      "Welcome to the Secure Area. When you are done click logout below.";

  private static final String BASIC_AUTH =
      "Congratulations! You must have the proper credentials.";

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

  @Step
  @Test
  public void basicAuthTest() {
    app.basicAuthPage.open("admin", "admin");
    logger.info("basicAuthPage start");
    softAssert.assertEquals(app.basicAuthPage.getBasicAuth(), BASIC_AUTH);
  }

  @Step
  @Test
  public void dropDownTest() {
    app.dropDownPage.open();
    logger.info("dropDownPage start");
    app.dropDownPage.selectOptionByValue("Option 1");
    softAssert.assertTrue( app.dropDownPage.isSelected());
  }
}
