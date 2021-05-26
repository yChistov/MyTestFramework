package com.mystore.core;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SelenoidDriverProvider implements WebDriverProvider {

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("profile.default_content_setting_values.notifications", 2);
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", prefs);
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability("browserVersion", "90.0");
    capabilities.setCapability(
        "selenoid:options",
        Map.<String, Object>of(
            "enableVNC", true,
            "enableVideo", true));
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    try {
      return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    } catch (final MalformedURLException e) {
      throw new RuntimeException("Unable to create driver", e);
    }
  }
}
