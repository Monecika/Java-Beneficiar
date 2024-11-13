package org.project;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private final String propFileName = "config.properties";
    private final Properties properties = new Properties();

    public ConfigLoader() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();

            } else {
                System.err.println("Error: Property file '" + propFileName + "' not found in the classpath.");
            }
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }


    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("Warning: Property key '" + key + "' not found in the properties file.");
        } else {
            System.out.println("Property '" + key + "' found with value: " + value);
        }
        return value;
    }
}
