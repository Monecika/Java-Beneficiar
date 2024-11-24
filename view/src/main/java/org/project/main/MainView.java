package org.project.main;

import org.project.Controller;
import org.project.View;
import org.project.main.components.init.MainComponents;
import org.project.main.components.table.AddBenOptionPane;
import org.project.main.components.table.DeleteButtonRenderer;
import org.project.mainController.MainController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainView extends View {
    private final MainController mainController;

    private final Color grayColor = new Color(78, 78, 78);
    private final MainComponents mainComponents = new MainComponents();
    private final ImageIcon iconDark = controller.getDarkImageIcon();
    private final ImageIcon iconLight = controller.getLightImageIcon();
    private final ImageIcon deleteIcon;

    private JFrame frame;
    private JPanel bodyPanel;
    private JPanel header;
    private JButton logoButton;
    private JButton deleteButton;

    private JMenuItem filterName;
    private JMenuItem filterSurname;
    private JMenuItem filterLocality;

    private JMenuItem viewAll;
    private JMenuItem viewRural;
    private JMenuItem viewSceptic;

    private JMenuItem add;

    private boolean isDarkTheme = false;

    private TableRowSorter<DefaultTableModel> sorter;
    private JTable table;
    private DefaultTableModel model;

    public MainView(Controller controller, MainController mainController) {
        super(controller);
        this.mainController = mainController;

        deleteIcon = mainController.getDeleteImageIcon();

    }

    public void init() throws SQLException {
        frame = new JFrame("Beneficiaries");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        logoButton = mainComponents.getLogoButton();
        logoButton.setIcon(iconDark);
        logoButton.addActionListener(e -> changeTheme());

        filterName = mainComponents.getFilterName();
        filterName.addActionListener(e -> mainController.setNameSortable(filterName, sorter));

        filterSurname = mainComponents.getFilterSurname();
        filterSurname.addActionListener(e -> mainController.setSurnameSortable(filterSurname, sorter));

        filterLocality = mainComponents.getFilterRegion();
        filterLocality.addActionListener(e -> mainController.setLocalitySortable(filterLocality, sorter));

        viewAll = mainComponents.getViewAll();
        viewAll.addActionListener(e -> {
            try {
                updateTableData(mainController.returnData(), mainController.returnAllColumns());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        viewRural = mainComponents.getViewRural();
        viewRural.addActionListener(e -> {
            try {
                updateTableData(mainController.returnFilteredData(), mainController.returnAllColumns());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        viewSceptic = mainComponents.getViewSceptic();
        viewSceptic.addActionListener(e -> {
            try {
                updateTableData(mainController.returnScepticData(), mainController.returnScepticDataColumns());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        add = mainComponents.getAdd();
        add.addActionListener(e -> addBenPane());

        header = mainComponents.getHeader();
        header.add(mainComponents.getLogo());
        header.add(Box.createHorizontalGlue());
        header.add(mainComponents.getMenuBar());
        header.add(Box.createHorizontalGlue());
        header.add(logoButton);

        bodyPanel = initBody();

        frame.add(header, BorderLayout.NORTH);
        frame.add(bodyPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel initBody() throws SQLException {
        List<String[]> data = mainController.returnData();

        if (data == null || data.isEmpty()) {
            data = new ArrayList<>();
        }

        String[] columnNames = mainController.returnAllColumns();

        model = new DefaultTableModel(data.toArray(new String[0][0]), columnNames);

        table = new JTable(model);

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        table.setDefaultEditor(Object.class, null);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1500, 600));
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
        tableColumnModel.getColumn(6).setPreferredWidth(200);

        tableColumnModel.getColumn(10).setCellRenderer(new DeleteButtonRenderer(deleteIcon));

        table = mainController.tableMouseListener(table, model);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        bodyPanel.add(scrollPane);
        return bodyPanel;
    }

    public void updateTableData(List<String[]> newData, String[] newColumnNames) {
        model.setDataVector(newData.toArray(new String[0][0]), newColumnNames);

        TableColumnModel tableColumnModel = table.getColumnModel();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);


        for (int i = 0; i < table.getColumnCount(); i++) {
            tableColumnModel.getColumn(i).setCellRenderer(centerRenderer);
        }

        tableColumnModel.getColumn(6).setCellRenderer(new DeleteButtonRenderer(deleteIcon));

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        table.revalidate();
        table.repaint();

    }

    private void changeTheme() {
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

    private void addBenPane() {
        AddBenOptionPane benOptionPane = new AddBenOptionPane();

    }
}
