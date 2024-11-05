package controller;

import javax.swing.*;
import java.awt.*;

public class CreateImage {
    public CreateImage() {
    }

    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        System.out.println(imgURL);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        return null;
    }
}
