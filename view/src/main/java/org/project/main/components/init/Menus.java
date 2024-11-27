package org.project.main.components.init;

import javax.swing.*;
import java.awt.*;

public class Menus {
    private final MainComponents mainComponents;

    public Menus(MainComponents mainComponents) {
        this.mainComponents = mainComponents;
    }

    public JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBorderPainted(false);

        menuBar.add(mainComponents.getHomeMenu());
        menuBar.add(mainComponents.getEditMenu());
        menuBar.add(mainComponents.getFilterMenu());
        menuBar.add(mainComponents.getViewMenu());
        menuBar.add(mainComponents.getWindowMenu());

        return menuBar;
    }

    public JMenu initHomeMenu() {
        JMenu homeMenu = new JMenu("Home");
        homeMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
        homeMenu.setBorder(BorderFactory.createEmptyBorder(13, 30, 0, 30));

        return homeMenu;
    }

    public JMenu initEditMenu() {
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(mainComponents.getUpdate());
        editMenu.add(mainComponents.getAdd());
        editMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        editMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));

        return editMenu;
    }

    public JMenu initFilterMenu() {
        JMenu filterMenu = new JMenu("Filter");

        filterMenu.add(mainComponents.getFilterName());
        filterMenu.add(mainComponents.getFilterSurname());
        filterMenu.add(mainComponents.getFilterRegion());
        filterMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        filterMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));

        return filterMenu;
    }

    public JMenu initViewMenu() {
        JMenu viewMenu = new JMenu("View");

        viewMenu.add(mainComponents.getViewAll());
        viewMenu.add(mainComponents.getViewRural());
        viewMenu.add(mainComponents.getViewSceptic());
        viewMenu.add(mainComponents.getExport());
        viewMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));
        viewMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));

        return viewMenu;
    }

    public JMenu initWindowMenu() {
        JMenu windowMenu = new JMenu("Window");

        windowMenu.add(mainComponents.getSearch());
        windowMenu.setBorder(BorderFactory.createEmptyBorder(15, 30, 0, 30));
        windowMenu.setFont(new Font("Ink Free", Font.PLAIN, 20));

        return windowMenu;
    }

    public JMenuItem initMenuItem(String name) {

        return new JMenuItem(name);
    }
}
