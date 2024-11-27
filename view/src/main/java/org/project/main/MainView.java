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

public class MainView extends View {
    private static final int EDITABLE_START_COLUMN = 1;
    private static final int EDITABLE_END_COLUMN = 6;

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
    private JMenuItem filterName;
    private JMenuItem filterSurname;
    private JMenuItem filterLocality;
    private JMenuItem viewAll;
    private JMenuItem viewRural;
    private JMenuItem viewSceptic;
    private JMenuItem update;
    private JMenuItem add;
    private JMenuItem toggleSearch;

    private JTextField searchField;

    private boolean isEditable = false;
    private boolean isDarkTheme = false;
    private boolean isVisible = false;

    private TableRowSorter<DefaultTableModel> sorter;
    private JTable table;
    private DefaultTableModel model;

    public MainView(Controller controller, MainController mainController) {
        super(controller);
        this.mainController = mainController;
        this.deleteIcon = mainController.getDeleteImageIcon();
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
        header.add(mainComponents.getSearchPanel());
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
                return isEditable && column >= EDITABLE_START_COLUMN && column <= EDITABLE_END_COLUMN;
            }
        };

        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
        table.setRowHeight(30);

        model.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                handleTableUpdate(e.getFirstRow(), e.getColumn());
            }
        });

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        table = mainController.tableMouseListener(table, model);

        setupTableProperties();

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
        add.addActionListener(e -> {
            try {
                addBenPane();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        update = mainComponents.getUpdate();
        update.addActionListener(e -> {
            mainController.updateToggle(update);
            revalidateBody();
        });

        toggleSearch = mainComponents.getSearch();
        toggleSearch.addActionListener(e -> {
            isVisible = !isVisible;
            searchField.setVisible(isVisible);
            toggleSearch.setText(mainController.addOrRemoveTick(toggleSearch.getText(), isVisible));

            header.repaint();
            header.revalidate();
        });

        searchField = mainComponents.getSearchField();
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                searchTable();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                searchTable();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                searchTable();
            }
        });
        searchField.setVisible(false);
    }

    public void updateTableData(List<String[]> newData, String[] newColumnNames) {
        model.setDataVector(newData.toArray(new String[0][0]), newColumnNames);
        model.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                handleTableUpdate(e.getFirstRow(), e.getColumn());
            }
        });

        setupTableProperties();

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        table = mainController.tableMouseListener(table, model);

        table.revalidate();
        table.repaint();
    }

    private void setupTableProperties() {
        TableColumnModel columnModel = table.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
            columnModel.getColumn(i).setResizable(false);
            if (i != 0) sorter.setSortable(i, false);
        }

        int deleteButtonColumnIndex = table.getColumnCount() - 1;
        columnModel.getColumn(deleteButtonColumnIndex).setCellRenderer(new DeleteButtonRenderer(deleteIcon));
        columnModel.getColumn(6).setPreferredWidth(200);
    }

    private void handleTableUpdate(int row, int column) {
        if (row == -1 || column == -1) {
            return;
        }

        String[] updateData = new String[model.getColumnCount()];
        for (int col = 0; col < model.getColumnCount(); col++) {
            updateData[col] = (String) model.getValueAt(row, col);
        }

        try {
            mainController.updateDisplayData(updateData);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void revalidateBody() {
        isEditable = !isEditable;
        table.revalidate();
        table.repaint();
    }

    private void addBenPane() throws SQLException {
        JComboBox environment = new JComboBox(mainController.getEnvironments());
        JComboBox locality = new JComboBox(mainController.getLocalities());
        JComboBox card = new JComboBox(mainController.getCardNumbers());

        int x = 304;
        int y = 30;
        environment.setPreferredSize(new Dimension(x, y));
        locality.setPreferredSize(new Dimension(x, y));
        card.setPreferredSize(new Dimension(x, y));

        AddBenOptionPane benOptionPane = new AddBenOptionPane(environment, locality, card);
        if (benOptionPane.getData() != null) mainController.addData(benOptionPane.getData());

        updateTableData(mainController.returnData(), mainController.returnAllColumns());
    }

    private void searchTable() {
        String query = searchField.getText().trim();
        if (query.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        }
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

}