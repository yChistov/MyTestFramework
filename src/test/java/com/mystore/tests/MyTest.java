package com.mystore.tests;

import com.mystore.helpers.TestListener;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class MyTest extends BaseTest {
  private static final String WELCOME_TEXT =
      "Welcome to the Secure Area. When you are done click logout below.";
  private static final String BASIC_AUTH = "Congratulations! You must have the proper credentials.";
  private static final String VALUE_OPTION = "Option 1";
  private static final int NUMBER_OF_BUTTON_CLICKS = 5;

  @Step
  @Test
  public void loginTest() {
    app.loginPage.open();
    app.loginPage.login("tomsmith", "SuperSecretPassword!");
    assertEquals(app.loginPage.getWelcomeText(), WELCOME_TEXT);
  }

  @Step
  @Test
  public void deleteButtonTest() {
    app.addAndRemovePage.open();
    app.addAndRemovePage.clickOnAddButton(NUMBER_OF_BUTTON_CLICKS);
    app.addAndRemovePage.clickOnDeleteButton();
    assertEquals(app.addAndRemovePage.getDeleteElementsSize(), 0);
  }

  @Step
  @Test
  public void basicAuthTest() {
    app.basicAuthPage.open("admin", "admin");
    assertEquals(app.basicAuthPage.getBasicAuth(), BASIC_AUTH);
  }

  @Step
  @Test
  public void dropDownTest() {
    app.dropDownPage.open();
    app.dropDownPage.selectOptionByValue(VALUE_OPTION);
    assertEquals(app.dropDownPage.getText(), VALUE_OPTION);
  }
}
