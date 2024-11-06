package view.components;


import controller.Controller;
import controller.CreateImage;
import view.MainView;
import view.View;

import javax.swing.*;
import java.awt.*;

public class initMainComponents extends View {
    private final CreateImage createImage = new CreateImage();
    private JLabel logo;
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenu editMenu;
    private JMenuItem update, delete, add;
    private JMenu filterMenu;
    private JMenuItem filterName, filterSurname, filterRegion;
    private JMenu viewMenu;
    private JMenuItem viewRural, viewSceptic, export;
    private JMenu windowMenu;
    private JMenuItem search;
    private JButton logoButton;

    private boolean isDarkTheme = false;

    public initMainComponents() {
    }

    public JPanel initHeader(String dark, String light, JFrame frame) {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        header.setBackground(Color.WHITE);

        logo = new JLabel("Logo");
        logo.setFont(new Font("Ink Free", Font.PLAIN, 30));
        logo.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBorderPainted(false);

        homeMenu = new JMenu("Home");
        homeMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
        homeMenu.setBorder(BorderFactory.createEmptyBorder(13, 30, 0, 30));

        editMenu = new JMenu("Edit");
        update = new JMenuItem("Update User");
        delete = new JMenuItem("Delete User");
        add = new JMenuItem("Add User");
        editMenu.add(update);
        editMenu.add(delete);
        editMenu.add(add);
        editMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        editMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));

        filterMenu = new JMenu("Filter");
        filterName = new JMenuItem("Filter By Name");
        filterSurname = new JMenuItem("Filter By Surname");
        filterRegion = new JMenuItem("Filter By Region");
        filterMenu.add(filterName);
        filterMenu.add(filterSurname);
        filterMenu.add(filterRegion);
        filterMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        filterMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));

        viewMenu = new JMenu("View");
        viewRural = new JMenuItem("View Rural Users");
        viewSceptic = new JMenuItem("View Sceptic Data");
        export = new JMenuItem("Export Users");
        viewMenu.add(viewRural);
        viewMenu.add(viewSceptic);
        viewMenu.add(export);
        viewMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
        viewMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));

        windowMenu = new JMenu("Window");
        search = new JMenuItem("Toggle Search");
        windowMenu.add(search);
        windowMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        windowMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));

        menuBar.add(homeMenu);
        menuBar.add(editMenu);
        menuBar.add(filterMenu);
        menuBar.add(viewMenu);
        menuBar.add(windowMenu);

        ImageIcon icon = new ImageIcon(createImage.createImageIcon(dark).getImage());
        ImageIcon icon2 = new ImageIcon(createImage.createImageIcon(light).getImage());
        logoButton = new JButton(isDarkTheme ? icon2 : icon);
        logoButton.setFocusPainted(false);
        logoButton.setContentAreaFilled(false);
        logoButton.setBorderPainted(false);
        logoButton.addActionListener(e -> {
            changeTheme(icon, icon2, frame);
        });

        header.add(logo);
        header.add(Box.createHorizontalGlue());
        header.add(menuBar);
        header.add(Box.createHorizontalGlue());
        header.add(logoButton);

        return header;
    }

    public JPanel initBody() {
        String[][] data = {{"1", "John", "Doe", "123 Main St", "ID001", "555-1234", "New York", "NY10001", "1234567890", "Operations"}, {"2", "Jane", "Smith", "456 Oak St", "ID002", "555-5678", "Los Angeles", "LA90001", "9876543210", "Operations"}, {"3", "Alice", "Johnson", "789 Pine St", "ID003", "555-9876", "Chicago", "CH60601", "4567891234", "Operations"}};
        String[] columnNames = {"BeneficiarId", "Name", "Surname", "Address", "DocumentID", "Phone", "Location", "Location Code", "CardNumber", "Operations"};

        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(753, 600));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        bodyPanel.add(scrollPane);
        return bodyPanel;
    }

    private void changeTheme(ImageIcon icon, ImageIcon icon2, JFrame frame) {
        isDarkTheme = !isDarkTheme;

        logoButton = new JButton(isDarkTheme ? icon : icon2);
        if (isDarkTheme) initDark();
        else initLight();

        SwingUtilities.updateComponentTreeUI(frame);
    }

}
