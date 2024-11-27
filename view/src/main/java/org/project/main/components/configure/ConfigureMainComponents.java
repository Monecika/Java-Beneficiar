package org.project.main.components.configure;

import org.project.main.components.init.MainComponents;

import javax.swing.*;
import java.awt.*;

public class ConfigureMainComponents {
    private final MainComponents mainComponents;

    public ConfigureMainComponents(MainComponents mainComponents) {
        this.mainComponents = mainComponents;
    }

    public JLabel initLogo() {
        JLabel logo = new JLabel("Logo");
        logo.setFont(new Font("Ink Free", Font.PLAIN, 30));
        logo.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        return logo;
    }

    public JButton logoButton() {
        JButton button = new JButton("");
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        return button;
    }

    public JTextField textField() {
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(new Dimension(100, 20));

        return textField;
    }

}
