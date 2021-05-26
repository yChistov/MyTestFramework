package com.mystore.app;

import com.mystore.app.pages.LoginPage;

public class App {
  public LoginPage loginPage;

  public App() {
    loginPage = PageBuilder.buildLoginPage();
  }
}
