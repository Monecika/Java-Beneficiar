package org.project;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String PROP_FILE_NAME = "ImageConfig.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME)) {
            if (inputStream != null) {
                PROPERTIES.load(inputStream);
            } else {
                System.err.println("Error: Property file '" + PROP_FILE_NAME + "' not found in the classpath.");
            }
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null) {
            System.err.println("Warning: Property key '" + key + "' not found in the properties file.");
        } else {
            System.out.println("Property '" + key + "' found with value: " + value);
        }
        return value;
    }
}
