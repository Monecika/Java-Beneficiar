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

    public void configureTable(DefaultTableModel model, JTable table, ImageIcon deleteIcon) {
        TableColumnModel tableColumnModel = table.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            tableColumnModel.getColumn(i).setCellRenderer(centerRenderer);
        }

        if (table.getColumnCount() > 10) {
            tableColumnModel.getColumn(10).setCellRenderer(new DeleteButtonRenderer(deleteIcon));
        }

        for (int i = 0; i < table.getColumnCount(); i++) {
            tableColumnModel.getColumn(i).setResizable(false);
        }
    }

}
