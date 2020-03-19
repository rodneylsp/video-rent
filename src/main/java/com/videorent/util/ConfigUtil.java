package com.videorent.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    private static final Logger logger = LogManager.getLogger(ConfigUtil.class);

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(ConfigUtil.class.getClassLoader().getResourceAsStream("videorent.properties"));
        } catch (IOException e) {
            logger.error("Erro ao carregar arquivo properties", e);
        }
    }

    private ConfigUtil(){}

    public static String getChromeWebDriver(){
        return prop.getProperty("webdriver.chrome.driver");
    }
}
