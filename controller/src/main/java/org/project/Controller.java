package org.project;

import javax.swing.*;

public class Controller {
    private final Model model;

    private final CreateImage createImage;

    public Controller(Model model) {
        this.model = model;

        this.createImage = new CreateImage();
    }

    public ImageIcon getDarkImageIcon() {
        return new ImageIcon(createImage.createImageIcon(getDarkIcon()).getImage());
    }

    public ImageIcon getLightImageIcon() {
        return new ImageIcon(createImage.createImageIcon(getLightIcon()).getImage());
    }

    public String getDarkIcon() {
        return ConfigLoader.getProperty("img.DARK_ICON_PATH");
    }

    private String getLightIcon() {
        return ConfigLoader.getProperty("img.LIGHT_ICON_PATH");
    }
}
