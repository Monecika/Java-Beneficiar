package org.project;

public class Model {
    private final ConfigLoader config;

    public Model() {
        this.config = new ConfigLoader();
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }

}
