package com.mystore.app.pages;

import com.codeborne.selenide.Selenide;
import com.mystore.app.AppConfig;
import com.mystore.helpers.Trim;

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

  public void open(String username, String password) {
    String auth = username + ":" + password + "@";
    String authUrl = "http://" +  auth + Trim.ltrim(AppConfig.baseUrl, "http://") + "/" + Trim.ltrim(pageUrl, "/");
    Selenide.open(authUrl);
    maximize();
  }
}
