package org.faina.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigProperties {
    private static final Logger log = LoggerFactory.getLogger(ConfigProperties.class);

    protected ConfigProperties() {
    }

    private static Map<String, String> getProperties() {
        Properties property = new Properties();
        Map<String, String> properties = new HashMap<>();
        InputStream input = ClassLoader.getSystemResourceAsStream("config.properties");
        if (input == null) {
            log.info("Cannot find config.properties file");
        }
        try {
            property.load(input);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        for (String prop : property.stringPropertyNames()) {
            properties.put(prop, property.getProperty(prop));
        }
        return properties;
    }


    public static String getProperty(String propertyName, String defaultValue) {
        String propertyValue = getProperties().get(propertyName);
        if (propertyValue == null) {
            log.info("value of {} is null", propertyName);
            try {
                throw new PropertyNotFoundException(propertyName + " not found");
            } catch (PropertyNotFoundException e) {
                log.error(e.getMessage());
            }
        }
        return (propertyValue == null) ? defaultValue : propertyValue;
    }

    public static long getProperty(String propertyName, int defaultValue) {
        String propertyValue = getProperties().get(propertyName);
        if (propertyValue == null) {
            log.info("value of {} is null", propertyName);
        }
        return (propertyValue == null) ? defaultValue : Integer.parseInt(propertyValue);
    }

    public static boolean getProperty(String propertyName, boolean defaultValue) {
        String propertyValue = getProperties().get(propertyName);
        if (propertyValue == null) {
            log.info("value of {} is null", propertyName);
        }
        return (propertyValue == null) ? defaultValue : Boolean.parseBoolean(propertyValue);
    }
}
