package org.project;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class View {
    protected final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public ImageIcon getIconDark() {
        return controller.getDarkImageIcon();
    }

    public ImageIcon getIconLight() {
        return controller.getLightImageIcon();
    }

    protected JButton initIconButton() {
        ImageIcon iconDark = getIconDark();

        JButton iconButton = new JButton(iconDark);
        iconButton.setContentAreaFilled(false);
        iconButton.setFocusPainted(false);
        iconButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        return iconButton;
    }

    protected void initDark() {
        FlatDarkLaf.setup();
        UIManager.put("Component.focusColor", new Color(85, 85, 85));
        UIManager.put("Menu.selectionBackground", new Color(70, 70, 70));
        UIManager.put("MenuItem.selectionBackground", new Color(85, 85, 85));
        UIManager.put("Table.selectionBackground", new Color(85, 85, 85));
        UIManager.put("List.selectionBackground", new Color(85, 85, 85));
    }

    protected void initLight() {
        FlatLightLaf.setup();
        UIManager.put("Component.focusColor", null);
        UIManager.put("Menu.selectionBackground", null);
        UIManager.put("MenuItem.selectionBackground", null);
        UIManager.put("Table.selectionBackground", null);
        UIManager.put("List.selectionBackground", null);
    }
}
