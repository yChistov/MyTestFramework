package com.mystore.app.pages;

import com.codeborne.selenide.Selenide;
import com.mystore.app.AppConfig;
import com.mystore.helpers.Trim;
import io.qameta.allure.Step;

import static com.mystore.helpers.Driver.maximize;

public abstract class BasePage {
  protected String pageUrl;

  public BasePage(String pageUrl) {
    this.pageUrl = pageUrl;
  }

  public void open() {
    String url = Trim.rtrim(AppConfig.baseUrl, "/") + "/" + Trim.ltrim(pageUrl, "/");
    Selenide.open(url);
    maximize();
  }

  @Step("username: {username} and password: {password}")
  public void open(String username, String password) {
    String auth = username + ":" + password + "@";
    String authUrl =
        "https://"
            + auth
            + Trim.ltrim(AppConfig.baseUrl, "https://")
            + "/"
            + Trim.ltrim(pageUrl, "/");
    Selenide.open(authUrl);
    maximize();
  }
}
