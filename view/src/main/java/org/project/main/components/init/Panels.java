package org.project.main.components.init;

import javax.swing.*;
import java.awt.*;

public class Panels {
    private final MainComponents mainComponents;

    public Panels(MainComponents mainComponents) {
        this.mainComponents = mainComponents;
    }

    public JPanel initHeaderPanel() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        header.setBackground(Color.WHITE);
        return header;
    }

    public JPanel searchPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setMaximumSize(new Dimension(200, 20));

        return panel;
    }
}
