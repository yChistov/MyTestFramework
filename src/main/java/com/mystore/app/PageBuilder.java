package com.mystore.app;

import com.mystore.app.pages.LoginPage;

public class PageBuilder {

  public static LoginPage buildLoginPage() {
    return new LoginPage("/login");
  }
}
