package com.mystore.app.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.mystore.helpers.Driver.waitForUrlContains;

public class LoginPage extends BasePage {

  private SelenideElement loginField = $("#username");
  private SelenideElement passwordField = $("#password");
  private SelenideElement signInButton = $(".radius");
  private SelenideElement welcomeText = $(".subheader");

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
