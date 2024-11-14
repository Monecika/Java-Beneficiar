package org.project.main;

import org.project.Controller;
import org.project.View;
import org.project.main.components.init.MainComponents;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class MainView extends View {
    private final Color grayColor = new Color(78, 78, 78);
    private final MainComponents mainComponents = new MainComponents();
    private final ImageIcon iconDark = controller.getDarkImageIcon();
    private final ImageIcon iconLight = controller.getLightImageIcon();

    private JFrame frame;
    private JPanel bodyPanel;
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
        frame = new JFrame("Beneficiaries");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        logoButton = mainComponents.getLogoButton();
        logoButton.setIcon(iconDark);
        logoButton.addActionListener(e -> changeTheme());

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

    private JPanel initBody() {
        String[][] data = {
                {"1", "John", "Doe", "123 Main St", "ID001", "555-1234", "New York", "NY10001", "1234567890", "Operations"},
                {"2", "Jane", "Smith", "456 Oak St", "ID002", "555-5678", "Los Angeles", "LA90001", "9876543210", "Operations"},
                {"3", "Alice", "Johnson", "789 Pine St", "ID003", "555-9876", "Chicago", "CH60601", "4567891234", "Operations"}
        };
        String[] columnNames = {"BeneficiaryId", "Name", "Surname", "Address", "DocumentID", "Phone", "Location", "Location Code", "CardNumber", "Operations"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        sorter = new TableRowSorter<>(model);
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

    private void setNameSortable() {
        isNameSortable = !isNameSortable;
        JMenuItem filterName = mainComponents.getFilterName();
        filterName.setText(controller.addOrRemoveTick(filterName.getText(), isNameSortable));
        sorter.setSortable(1, isNameSortable);
    }

    private void setSurnameSortable() {
        isSurnameSortable = !isSurnameSortable;
        JMenuItem filterSurname = mainComponents.getFilterSurname();
        filterSurname.setText(controller.addOrRemoveTick(filterSurname.getText(), isSurnameSortable));
        sorter.setSortable(2, isSurnameSortable);
    }
}
