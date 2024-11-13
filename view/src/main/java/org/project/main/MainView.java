package org.project.main;

import org.project.Controller;
import org.project.View;
import org.project.main.components.initMainComponents;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class MainView extends View {
    private final Color grayColor = new Color(78, 78, 78);
    private initMainComponents init;

    private JFrame frame;
    private JPanel bodyPanel;
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
    private JButton logoButton;
    private JPanel header;

    private boolean isDarkTheme = false;
    private boolean isNameSortable = false;
    private boolean isSurnameSortable = false;

    private TableRowSorter<DefaultTableModel> sorter;

    public MainView(Controller controller) {
        super(controller);
    }

    public void init() {
        frame = new JFrame();
        frame.setTitle("Beneficiaris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        init = new initMainComponents();
        windowMenu = init.getWindowMenu();
        search = init.getSearch();
        viewMenu = init.getViewMenu();
        viewRural = init.getViewRural();
        viewSceptic = init.getViewSceptic();
        export = init.getExport();
        filterMenu = init.getFilterMenu();

        filterName = init.getFilterName();
        filterName.addActionListener(e -> {
            setNameSortable();
        });

        filterSurname = init.getFilterSurname();
        filterSurname.addActionListener(e -> {
            setSurnameSortable();
        });

        filterRegion = init.getFilterRegion();
        logo = init.getLogo();
        menuBar = init.getMenuBar();
        homeMenu = init.getHomeMenu();
        editMenu = init.getEditMenu();
        update = init.getUpdate();
        delete = init.getDelete();
        add = init.getAdd();

        ImageIcon iconDark = controller.getDarkImageIcon();
        ImageIcon iconLight = controller.getLightImageIcon();
        logoButton = new JButton(isDarkTheme ? iconLight : iconDark);
        logoButton = init.setLogoButton(logoButton);
        logoButton.addActionListener(e -> {
            changeTheme(iconDark, iconLight);
        });

        header = init.getHeader();
        header.add(logo);
        header.add(Box.createHorizontalGlue());
        header.add(menuBar);
        header.add(Box.createHorizontalGlue());
        header.add(logoButton);

        bodyPanel = initBody();


        frame.add(header, BorderLayout.NORTH);
        frame.add(bodyPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel initBody() {
        String[][] data = {{"1", "John", "Doe", "123 Main St", "ID001", "555-1234", "New York", "NY10001", "1234567890", "Operations"}, {"2", "Jane", "Smith", "456 Oak St", "ID002", "555-5678", "Los Angeles", "LA90001", "9876543210", "Operations"}, {"3", "Alice", "Johnson", "789 Pine St", "ID003", "555-9876", "Chicago", "CH60601", "4567891234", "Operations"}};
        String[] columnNames = {"BeneficiarId", "Name", "Surname", "Address", "DocumentID", "Phone", "Location", "Location Code", "CardNumber", "Operations"};

        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        sorter = new TableRowSorter<>(new DefaultTableModel(data, columnNames));
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 600));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        TableColumnModel tableColumnModel = table.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            tableColumnModel.getColumn(i).setCellRenderer(centerRenderer);
            tableColumnModel.getColumn(i).setResizable(false);
            sorter.setSortable(i, false);
        }
        sorter.setSortable(0, true);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        bodyPanel.add(scrollPane);
        return bodyPanel;
    }

    private void changeTheme(ImageIcon iconDark, ImageIcon iconLight) {
        isDarkTheme = !isDarkTheme;

        logoButton.setIcon(isDarkTheme ? iconLight : iconDark);
        if (isDarkTheme) {
            initDark();
            header.setBackground(grayColor);
        } else {
            initLight();
            header.setBackground(Color.WHITE);
        }

        SwingUtilities.updateComponentTreeUI(frame);
    }

    private void setNameSortable() {
        isNameSortable = !isNameSortable;
        filterName.setText(controller.addOrRemoveTick(filterName.getText(), isNameSortable));
        sorter.setSortable(1, isNameSortable);
    }

    private void setSurnameSortable() {
        isSurnameSortable = !isSurnameSortable;
        filterSurname.setText(controller.addOrRemoveTick(filterSurname.getText(), isSurnameSortable));
        sorter.setSortable(2, isSurnameSortable);
    }
}
