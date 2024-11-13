package org.project;

import javax.swing.*;
import java.awt.*;

public class CreateImage {
    public CreateImage() {
    }

    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path.startsWith("/") ? path : "/" + path);

        System.out.println("Attempting to load image from: " + path);
        System.out.println("Resolved URL: " + imgURL);

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } else {
            System.err.println("Image file not found: " + path);
        }
        return null;
    }

}
