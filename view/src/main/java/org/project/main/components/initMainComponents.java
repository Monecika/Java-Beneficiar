package org.project.main.components;

import org.project.CreateImage;

import javax.swing.*;
import java.awt.*;

public class initMainComponents {
    private final CreateImage createImage = new CreateImage();
    private JMenu windowMenu;
    private JMenuItem search;
    private JMenu viewMenu;
    private JMenuItem viewRural;
    private JMenuItem viewSceptic;
    private JMenuItem export;
    private JMenu filterMenu;
    private JMenuItem filterName;
    private JMenuItem filterSurname;
    private JMenuItem filterRegion;
    private JLabel logo;
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenu editMenu;
    private JMenuItem update;
    private JMenuItem delete;
    private JMenuItem add;
    private JPanel header;


    public initMainComponents() {
        initHeaderPanel();
        initLogo();
        initMenus();
    }

    private void initHeaderPanel() {
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        header.setBackground(Color.WHITE);
    }

    private void initLogo() {
        logo = new JLabel("Logo");
        logo.setFont(new Font("Ink Free", Font.PLAIN, 30));
        logo.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
    }

    private void initMenus() {
        initHomeMenu();
        initEditMenu();
        initViewMenu();
        initFilterMenu();
        initWindowMenu();

        initMenuBar();
    }

    private void initHomeMenu() {
        homeMenu = new JMenu("Home");
        homeMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
        homeMenu.setBorder(BorderFactory.createEmptyBorder(13, 30, 0, 30));
    }

    private void initEditMenu() {
        editMenu = new JMenu("Edit");
        update = new JMenuItem("Update User");
        delete = new JMenuItem("Delete User");
        add = new JMenuItem("Add User");

        editMenu.add(update);
        editMenu.add(delete);
        editMenu.add(add);
        editMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        editMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
    }

    private void initFilterMenu() {
        filterMenu = new JMenu("Filter");
        filterName = new JMenuItem("Filter By Name");
        filterSurname = new JMenuItem("Filter By Surname");
        filterRegion = new JMenuItem("Filter By Region");
        filterMenu.add(filterName);
        filterMenu.add(filterSurname);
        filterMenu.add(filterRegion);
        filterMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        filterMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
    }

    private void initViewMenu() {
        viewMenu = new JMenu("View");
        viewRural = new JMenuItem("View Rural Users");
        viewSceptic = new JMenuItem("View Sceptic Data");
        export = new JMenuItem("Export Users");
        viewMenu.add(viewRural);
        viewMenu.add(viewSceptic);
        viewMenu.add(export);
        viewMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
        viewMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
    }

    private void initWindowMenu() {
        windowMenu = new JMenu("Window");
        search = new JMenuItem("Toggle Search");
        windowMenu.add(search);
        windowMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        windowMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
    }

    private void initMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBorderPainted(false);

        menuBar.add(homeMenu);
        menuBar.add(editMenu);
        menuBar.add(filterMenu);
        menuBar.add(viewMenu);
        menuBar.add(windowMenu);
    }


    public JMenu getWindowMenu() {
        return windowMenu;
    }

    public JMenuItem getSearch() {
        return search;
    }

    public JMenu getViewMenu() {
        return viewMenu;
    }

    public JMenuItem getViewRural() {
        return viewRural;
    }

    public JMenuItem getViewSceptic() {
        return viewSceptic;
    }

    public JMenuItem getExport() {
        return export;
    }

    public JMenu getFilterMenu() {
        return filterMenu;
    }

    public JMenuItem getFilterName() {
        return filterName;
    }

    public JMenuItem getFilterSurname() {
        return filterSurname;
    }

    public JMenuItem getFilterRegion() {
        return filterRegion;
    }

    public JLabel getLogo() {
        return logo;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenu getHomeMenu() {
        return homeMenu;
    }

    public JMenu getEditMenu() {
        return editMenu;
    }

    public JMenuItem getUpdate() {
        return update;
    }

    public JMenuItem getDelete() {
        return delete;
    }

    public JMenuItem getAdd() {
        return add;
    }


    public JButton setLogoButton(JButton button) {
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        return button;
    }

    public JPanel getHeader() {
        return header;
    }

}
