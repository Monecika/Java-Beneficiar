package org.project.main.components.init;

import org.project.main.components.configure.ConfigureMainComponents;

import javax.swing.*;

public class MainComponents {
    private final ConfigureMainComponents configureMainComponents;
    private final Menus menus;
    private final Panels panels;

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
    private JButton logoButton;


    public MainComponents() {
        this.configureMainComponents = new ConfigureMainComponents(this);
        this.menus = new Menus(this);
        this.panels = new Panels(this);


        update = menus.initMenuItem("Update User");
        delete = menus.initMenuItem("Delete User");
        add = menus.initMenuItem("Add User");
        filterName = menus.initMenuItem("Filter User");
        filterSurname = menus.initMenuItem("Filter Surname");
        filterRegion = menus.initMenuItem("Filter Region");
        viewRural = menus.initMenuItem("View Rural");
        viewSceptic = menus.initMenuItem("View Sceptic");
        export = menus.initMenuItem("Export User");
        search = menus.initMenuItem("Toggle Search");


        logo = configureMainComponents.initLogo();
        homeMenu = menus.initHomeMenu();
//        System.out.println(123);
        editMenu = menus.initEditMenu();
        filterMenu = menus.initFilterMenu();
        viewMenu = menus.initViewMenu();
        windowMenu = menus.initWindowMenu();
        menuBar = menus.initMenuBar();

        logoButton = configureMainComponents.logoButton();
        header = panels.initHeaderPanel();
    }

    public JMenu getWindowMenu() {
        return windowMenu;
    }

    public void setWindowMenu(JMenu windowMenu) {
        this.windowMenu = windowMenu;
    }

    public JMenuItem getSearch() {
        return search;
    }

    public void setSearch(JMenuItem search) {
        this.search = search;
    }

    public JMenu getViewMenu() {
        return viewMenu;
    }

    public void setViewMenu(JMenu viewMenu) {
        this.viewMenu = viewMenu;
    }

    public JMenuItem getViewRural() {
        return viewRural;
    }

    public void setViewRural(JMenuItem viewRural) {
        this.viewRural = viewRural;
    }

    public JMenuItem getViewSceptic() {
        return viewSceptic;
    }

    public void setViewSceptic(JMenuItem viewSceptic) {
        this.viewSceptic = viewSceptic;
    }

    public JMenuItem getExport() {
        return export;
    }

    public void setExport(JMenuItem export) {
        this.export = export;
    }

    public JMenu getFilterMenu() {
        return filterMenu;
    }

    public void setFilterMenu(JMenu filterMenu) {
        this.filterMenu = filterMenu;
    }

    public JMenuItem getFilterName() {
        return filterName;
    }

    public void setFilterName(JMenuItem filterName) {
        this.filterName = filterName;
    }

    public JMenuItem getFilterSurname() {
        return filterSurname;
    }

    public void setFilterSurname(JMenuItem filterSurname) {
        this.filterSurname = filterSurname;
    }

    public JMenuItem getFilterRegion() {
        return filterRegion;
    }

    public void setFilterRegion(JMenuItem filterRegion) {
        this.filterRegion = filterRegion;
    }

    public JLabel getLogo() {
        return logo;
    }

    public void setLogo(JLabel logo) {
        this.logo = logo;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getHomeMenu() {
        return homeMenu;
    }

    public void setHomeMenu(JMenu homeMenu) {
        this.homeMenu = homeMenu;
    }

    public JMenu getEditMenu() {
        return editMenu;
    }

    public void setEditMenu(JMenu editMenu) {
        this.editMenu = editMenu;
    }

    public JMenuItem getUpdate() {
        return update;
    }

    public void setUpdate(JMenuItem update) {
        this.update = update;
    }

    public JMenuItem getDelete() {
        return delete;
    }

    public void setDelete(JMenuItem delete) {
        this.delete = delete;
    }

    public JMenuItem getAdd() {
        return add;
    }

    public void setAdd(JMenuItem add) {
        this.add = add;
    }

    public JPanel getHeader() {
        return header;
    }

    public void setHeader(JPanel header) {
        this.header = header;
    }

    public JButton getLogoButton() {
        return logoButton;
    }

    public void setLogoButton(JButton logoButton) {
        this.logoButton = logoButton;
    }
}
