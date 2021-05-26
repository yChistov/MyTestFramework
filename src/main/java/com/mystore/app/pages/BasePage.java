package com.mystore.app.pages;

import com.codeborne.selenide.Selenide;
import com.mystore.app.AppConfig;
import com.mystore.helpers.Trim;

public abstract class BasePage {
  protected String pageUrl;

  public BasePage(String pageUrl) {
    this.pageUrl = pageUrl;
  }

  public void open() {
    String url = Trim.rtrim(AppConfig.baseUrl, "/") + "/" + Trim.ltrim(pageUrl, "/");
    Selenide.open(url);
  }
}
