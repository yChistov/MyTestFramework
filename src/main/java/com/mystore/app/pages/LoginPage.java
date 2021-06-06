package com.mystore.app.pages;

import com.codeborne.selenide.SelenideElement;
import com.mystore.helpers.Driver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

  private SelenideElement loginField = $("#username");
  private SelenideElement passwordField = $("#password");
  private SelenideElement signInButton = $(".radius");
  private SelenideElement welcomeText = $(".subheader");

  public LoginPage(String pageUrl) {
    super(pageUrl);
  }

  public void login(String email, String password) {
    loginField.setValue(email);
    passwordField.setValue(password);
    signInButton.click();
    Driver.waitForUrlContains("secure");
  }

  public String getWelcomeText() {
    return welcomeText.getText();
  }
}
