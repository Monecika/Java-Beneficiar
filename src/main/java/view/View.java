package view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class View {
    public View() {
    }

    protected void initDark() {
        FlatDarkLaf.setup();
        UIManager.put("Component.focusColor", new Color(85, 85, 85)); // Light purple focus color
        UIManager.put("Menu.selectionBackground", new Color(70, 70, 70));
        UIManager.put("Button.hoverBackground", new Color(60, 63, 65));  // Dark gray for button hover
        UIManager.put("MenuItem.selectionBackground", new Color(85, 85, 85)); // Darker gray for menu item hover
        UIManager.put("Table.selectionBackground", new Color(85, 85, 85)); // Blue shade for table row selection
        UIManager.put("List.selectionBackground", new Color(85, 85, 85)); // Gray for list item hover
    }

    protected void initLight() {
        FlatLightLaf.setup();
    }

}
