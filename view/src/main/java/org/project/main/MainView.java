package org.project.main;

import org.project.Controller;
import org.project.View;
import org.project.main.components.init.MainComponents;
import org.project.main.components.table.AddBenOptionPane;
import org.project.main.components.table.DeleteButtonRenderer;
import org.project.mainController.MainController;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private JMenuItem update;
    private JMenuItem add;

    private  boolean isEditable = true;
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

        initMenuItems();

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
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make cells editable only when isEditable is true and column is within editable range
                return isEditable && column >= 1 && column <= 6;
            }
        };

        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
        table.setRowHeight(30);

        model.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                if (row == -1 || column == -1) {
                    return;
                }

                String[] updateData = new String[model.getColumnCount()];
                for (int col = 0; col < model.getColumnCount(); col++) {
                    String value = (String) model.getValueAt(row, col);
                    updateData[col] = value;
                }

                try {
                    mainController.updateDisplayData(updateData);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        configureTable(model, table, deleteIcon);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1500, 600));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        bodyPanel.add(scrollPane);

        return bodyPanel;
    }

    private void initMenuItems() {
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

        update = mainComponents.getUpdate();
        update.addActionListener(e -> revalidateBody());

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

    public void updateTableData(List<String[]> newData, String[] newColumnNames) {
        model.setDataVector(newData.toArray(new String[0][0]), newColumnNames);

        configureTable(model, table, deleteIcon);

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        table.revalidate();
        table.repaint();
    }

    private void addBenPane() {
        AddBenOptionPane benOptionPane = new AddBenOptionPane();
    }

    private void configureTable(DefaultTableModel model, JTable table, ImageIcon deleteIcon) {
        TableColumnModel tableColumnModel = table.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            tableColumnModel.getColumn(i).setCellRenderer(centerRenderer);
            tableColumnModel.getColumn(i).setResizable(false);
            if (i != 0) sorter.setSortable(i, false);
        }

        int deleteButtonColumnIndex = table.getColumnCount() - 1;

        tableColumnModel.getColumn(deleteButtonColumnIndex).setCellRenderer(new DeleteButtonRenderer(deleteIcon));
        tableColumnModel.getColumn(6).setPreferredWidth(200);
    }

    private void revalidateBody() {
        isEditable = !isEditable;

        frame.remove(bodyPanel); // Remove the old body panel
        try {
            bodyPanel = initBody(); // Reinitialize the body
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        frame.add(bodyPanel, BorderLayout.CENTER); // Add the new body panel
        frame.revalidate(); // Refresh the frame
        frame.repaint();
    }

}
