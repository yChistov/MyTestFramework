package com.mystore.helpers;

public class TestConfig {
    public static String browser = "chrome";
    public static String headless = "0";
    public static String environment = "local";

    public static void initConfig() {
        browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
        environment = System.getProperty("environment") == null ? "local" : System.getProperty("environment");
    }

    public static boolean isHeadless() {
        return headless.contains("1");
    }
}
