package model;

public class MainModel {
    private final ConfigLoader configLoader;

    public MainModel() {
        this.configLoader = new ConfigLoader();
    }

    public String getProperty(String key) {
        return configLoader.getProperty(key);
    }
}
