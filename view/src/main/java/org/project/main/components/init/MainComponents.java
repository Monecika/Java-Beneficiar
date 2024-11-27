package org.project.main.components.init;

import org.project.main.components.configure.ConfigureMainComponents;

import javax.swing.*;

public class MainComponents {
    private final ConfigureMainComponents configureMainComponents;
    private final Menus menus;
    private final Panels panels;

    private final JMenu windowMenu;
    private final JMenuItem search;
    private final JMenu viewMenu;
    private final JMenuItem viewAll;
    private final JMenuItem viewRural;
    private final JMenuItem viewSceptic;
    private final JMenuItem export;
    private final JMenu filterMenu;
    private final JMenuItem filterName;
    private final JMenuItem filterSurname;
    private final JMenuItem filterRegion;
    private final JLabel logo;
    private final JMenuBar menuBar;
    private final JMenu homeMenu;
    private final JMenu editMenu;
    private final JMenuItem update;
    private final JMenuItem add;
    private final JPanel header;
    private final JButton logoButton;

    private final JPanel searchPanel;
    private final JTextField searchField;


    public MainComponents() {
        this.configureMainComponents = new ConfigureMainComponents();
        this.menus = new Menus(this);
        this.panels = new Panels();


        update = menus.initMenuItem("Update User");
        add = menus.initMenuItem("Add User");
        filterName = menus.initMenuItem("Filter User");
        filterSurname = menus.initMenuItem("Filter Surname");
        filterRegion = menus.initMenuItem("Filter Region");
        viewAll = menus.initMenuItem("View All");
        viewRural = menus.initMenuItem("View Rural");
        viewSceptic = menus.initMenuItem("View Sceptic");
        export = menus.initMenuItem("Export User");
        search = menus.initMenuItem("Toggle Search");


        logo = configureMainComponents.initLogo();
        homeMenu = menus.initHomeMenu();
        editMenu = menus.initEditMenu();
        filterMenu = menus.initFilterMenu();
        viewMenu = menus.initViewMenu();
        windowMenu = menus.initWindowMenu();
        menuBar = menus.initMenuBar();

        logoButton = configureMainComponents.logoButton();
        header = panels.initHeaderPanel();

        searchPanel = panels.searchPanel();
        searchField = configureMainComponents.textField();
        searchPanel.add(searchField);
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

    public JMenuItem getViewAll() {
        return viewAll;
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

    public JMenuItem getAdd() {
        return add;
    }

    public JPanel getHeader() {
        return header;
    }

    public JButton getLogoButton() {
        return logoButton;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public JTextField getSearchField() {
        return searchField;
    }
}
