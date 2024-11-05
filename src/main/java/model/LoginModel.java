package model;

public class LoginModel {
    private final ConfigLoader configLoader;

    public LoginModel() {
        this.configLoader = new ConfigLoader();
    }

    public String getProperty(String key) {
        return configLoader.getProperty(key);
    }
}
