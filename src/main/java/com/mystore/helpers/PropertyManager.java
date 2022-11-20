package com.mystore.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static final String propertyFilePath = System.getProperty("user.dir") +
            "\\src\\test\\resources\\config.properties";
    private static String google;
    private static String herokuapp;
    private static String elmir;

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        //Get properties from configuration.properties
        google = prop.getProperty("google.url");
        herokuapp = prop.getProperty("herokuapp.url");
        elmir = prop.getProperty("elmir.url");
    }

    public String getGoogle() {
        return google;
    }

    public String getHerokuapp() {
        return herokuapp;
    }

    public String getElmir() {
        return elmir;
    }
}
