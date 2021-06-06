package com.mystore.app;

import com.mystore.app.pages.AddAndRemovePage;
import com.mystore.app.pages.LoginPage;

public class PageBuilder {

  public static LoginPage buildLoginPage() {
    return new LoginPage("/login");
  }

  public static AddAndRemovePage buildAddAndRemovePage() {
    return new AddAndRemovePage("add_remove_elements/");
  }
}
