package org.project;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties PROPERTIES = new Properties();

    private static void initPropFile(String key) {
        String property = key.split("\\.")[0];  // Fixed regex issue
        String propFileName = null;

        if ("db".equals(property)) {
            propFileName = "DatabaseConfig.properties";
        } else if ("sql".equals(property)) {
            propFileName = "SQLConfig.properties";
        } else if ("img".equals(property)) {
            propFileName = "ImageConfig.properties";
        }

        if (propFileName != null) {
            try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(propFileName)) {
                if (inputStream != null) {
                    PROPERTIES.load(inputStream);
                } else {
                    System.err.println("Error: Property file " + propFileName + " not found in the classpath.");
                }
            } catch (IOException e) {
                System.err.println("Error loading properties file: " + e.getMessage());
            }
        } else {
            System.err.println("Error: Invalid property key provided.");
        }
    }

    public static String getProperty(String key) {
        initPropFile(key);

        String value = PROPERTIES.getProperty(key);
        if (value == null) {
            System.err.println("Warning: Property key '" + key + "' not found in the properties file.");
        } else {
            System.out.println("Property '" + key + "' found with value: " + value);
        }
        return value;
    }
}
