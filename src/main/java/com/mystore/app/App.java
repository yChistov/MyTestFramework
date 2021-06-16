package com.mystore.app;

import com.mystore.app.pages.AddAndRemovePage;
import com.mystore.app.pages.BasicAuthPage;
import com.mystore.app.pages.DropDownPage;
import com.mystore.app.pages.LoginPage;

public class App {
  public LoginPage loginPage;
  public AddAndRemovePage addAndRemovePage;
  public BasicAuthPage basicAuthPage;
  public DropDownPage dropDownPage;

  public App() {
    loginPage = PageBuilder.buildLoginPage();
    addAndRemovePage = PageBuilder.buildAddAndRemovePage();
    basicAuthPage = PageBuilder.buildBasicAuthPage();
    dropDownPage = PageBuilder.buildDropDownPage();
  }
}
