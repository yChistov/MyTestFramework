package com.mystore.app;

import com.mystore.app.pages.*;

public class App {
  public LoginPage loginPage;
  public AddAndRemovePage addAndRemovePage;
  public BasicAuthPage basicAuthPage;
  public DropDownPage dropDownPage;
  public ShadowDomPage shadowDomPage;

  public App() {
    loginPage = PageBuilder.buildLoginPage();
    addAndRemovePage = PageBuilder.buildAddAndRemovePage();
    basicAuthPage = PageBuilder.buildBasicAuthPage();
    dropDownPage = PageBuilder.buildDropDownPage();
    shadowDomPage = PageBuilder.buildShadowDomPage();
  }
}
