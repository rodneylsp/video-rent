package com.videorent.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(ConfigUtil.class.getClassLoader().getResourceAsStream("videorent.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getChromeWebDriver(){
        return prop.getProperty("webdriver.chrome.driver");
    }
}
