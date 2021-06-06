package com.mystore.app;

import com.mystore.app.pages.AddAndRemovePage;
import com.mystore.app.pages.LoginPage;

public class App {
  public LoginPage loginPage;
  public AddAndRemovePage addAndRemovePage;

  public App() {
    loginPage = PageBuilder.buildLoginPage();
    addAndRemovePage = PageBuilder.buildAddAndRemovePage();
  }
}
