package com.mystore.app.pages;

import com.codeborne.selenide.SelenideElement;
import com.mystore.helpers.Driver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

  public SelenideElement loginField = $("#username");
  public SelenideElement passwordField = $("#password");
  public SelenideElement signInButton = $(".radius");

  public LoginPage(String pageUrl) {
    super(pageUrl);
  }

  public void login(String email, String password) {
    loginField.setValue(email);
    passwordField.setValue(password);
    signInButton.click();
    Driver.waitForUrlContains("secure");
  }
}
