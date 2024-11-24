package org.project.main.components.configure;

import org.project.main.components.init.MainComponents;
import org.project.main.components.table.DeleteButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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

}
