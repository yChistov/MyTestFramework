package com.mystore.app;

import com.mystore.app.pages.AddAndRemovePage;
import com.mystore.app.pages.BasicAuthPage;
import com.mystore.app.pages.DropDownPage;
import com.mystore.app.pages.LoginPage;

public class PageBuilder {

  public static LoginPage buildLoginPage() {
    return new LoginPage("/login");
  }

  public static AddAndRemovePage buildAddAndRemovePage() {
    return new AddAndRemovePage("/add_remove_elements/");
  }

  public static BasicAuthPage buildBasicAuthPage() {
    return new BasicAuthPage("/basic_auth");
  }

  public static DropDownPage buildDropDownPage() {
    return new DropDownPage("/dropdown");
  }
}
