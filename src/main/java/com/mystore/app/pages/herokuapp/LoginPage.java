package com.mystore.app.pages.herokuapp;

import com.codeborne.selenide.SelenideElement;
import com.mystore.app.pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.mystore.helpers.Driver.waitForUrlContains;

public class LoginPage extends BasePage {

  private final SelenideElement loginField = $("#username");
  private final SelenideElement passwordField = $("#password");
  private final SelenideElement signInButton = $(".radius");
  private final SelenideElement welcomeText = $(".subheader");

  public LoginPage(String pageUrl) {
    super(pageUrl);
  }

  @Step("email: {email} and password: {password}")
  public void login(String email, String password) {
    loginField.setValue(email);
    passwordField.setValue(password);
    signInButton.click();
    waitForUrlContains("secure");
  }

  public String getWelcomeText() {
    return welcomeText.getText();
  }
}
