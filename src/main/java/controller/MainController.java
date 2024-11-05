package controller;

import model.MainModel;

public class MainController {
    private final MainModel model;

    public MainController(MainModel model) {
        this.model = model;
    }

    public String getDarkIcon() {
        return model.getProperty("DARK_ICON_PATH");
    }

    public String getLightIcon() {
        return model.getProperty("LIGHT_ICON_PATH");
    }
}
