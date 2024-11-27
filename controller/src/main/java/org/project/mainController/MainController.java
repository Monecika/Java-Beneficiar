package org.project.mainController;

import org.project.ConfigLoader;
import org.project.Controller;
import org.project.CreateImage;
import org.project.Model;
import org.project.entity.*;
import org.project.mainModel.MainModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainController extends Controller {
    private final MainModel mainModel;

    private final CreateImage createImage;

    private boolean isNameSortable = false;
    private boolean isSurnameSortable = false;
    private boolean isLocalitySortable = false;
    private boolean isEditable = false;


    public MainController(Model model, MainModel mainModel) {
        super(model);
        this.mainModel = mainModel;

        this.createImage = new CreateImage();
    }

    public void updateDisplayData(String[] data) throws SQLException {
        mainModel.updateDisplayData(data);
    }


    public List<String[]> returnData() throws SQLException {

        List<String[]> data = new ArrayList<>();

        List<DisplayData> displayData = mainModel.getDisplayData();
        for (DisplayData d : displayData) {
            String[] display = {d.getCodeBen(), d.getNameBen(), d.getSurnameBen(), d.getPhoneBen(), d.getIDNP(), d.getAddressBen(), d.getEmailBen(), d.getLocalityName(), d.getEnvironment(), d.getCardNumber()};
            data.add(display);
        }

        return data;
    }

    public List<String[]> returnFilteredData() throws SQLException {
        List<String[]> data = returnData();
        List<String[]> filteredData = new ArrayList<>();

        for (String[] d : data) {
            if (d[8].equalsIgnoreCase("rural")) filteredData.add(d);
        }
        return filteredData;
    }

    public List<String[]> returnScepticData() throws SQLException {
        List<String[]> data = new ArrayList<>();
        List<ScepticData> displayData = mainModel.getScepticData();
        for (ScepticData sceptic : displayData) {
            String[] display = {sceptic.getCodeBen(), sceptic.getNameBen(), sceptic.getSurnameBen(), sceptic.getPhoneBen(), sceptic.getAddressBen(), sceptic.getEmailBen()};
            data.add(display);
        }
        return data;
    }

    public String[] returnAllColumns() {
        String[] columnNames = {"BeneficiaryId", "Name", "Surname", "Phone Number", "IDNP", "Address", "Email", "Locality", "Environment", "CardNumber", "Operations"};
        return columnNames;
    }

    public String[] returnScepticDataColumns() {
        String[] columnNames = {"BeneficiaryId", "Name", "Surname", "Phone Number", "Address", "Email", "Operations"};

        return columnNames;
    }

    public String addOrRemoveTick(String text, boolean value) {
        if (value) return text + " ✔";
        return text.substring(0, text.length() - 1);
    }

    public ImageIcon getDeleteImageIcon() {
        ImageIcon icon = new ImageIcon(createImage.createImageIcon(getDeleteIcon()).getImage());
        return icon;
    }

    private String getDeleteIcon() {
        return ConfigLoader.getProperty("img.DELETE_ICON_PATH");
    }

    public JTable tableMouseListener(JTable table, DefaultTableModel model) {
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (column == table.getColumnCount()-1 && row != -1) {
                    int modelRow = table.convertRowIndexToModel(row);
                    String firstColumnData = (String) table.getValueAt(row, 0);
                    model.removeRow(modelRow);
                    try {
                        mainModel.deleteBen(firstColumnData);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        return table;
    }

    public void setNameSortable(JMenuItem filterName, TableRowSorter<DefaultTableModel> sorter) {
        isNameSortable = !isNameSortable;
        filterName.setText(addOrRemoveTick(filterName.getText(), isNameSortable));
        sorter.setSortable(1, isNameSortable);
    }

    public void setSurnameSortable(JMenuItem filterSurname, TableRowSorter<DefaultTableModel> sorter) {
        isSurnameSortable = !isSurnameSortable;
        filterSurname.setText(addOrRemoveTick(filterSurname.getText(), isSurnameSortable));
        sorter.setSortable(2, isSurnameSortable);
    }

    public void setLocalitySortable(JMenuItem filterLocality, TableRowSorter<DefaultTableModel> sorter) {
        isLocalitySortable = !isLocalitySortable;
        filterLocality.setText(addOrRemoveTick(filterLocality.getText(), isLocalitySortable));
        sorter.setSortable(7, isLocalitySortable);
    }

    public void updateToggle(JMenuItem update) {
        isEditable = !isEditable;
        update.setText(addOrRemoveTick(update.getText(), isEditable));
    }

    public String[] getEnvironments() throws SQLException {
        List<Environments> data = mainModel.getEnvironment();
        String[] environments = new String[data.size()];

        for(int i = 0; i < data.size(); i++) {
            environments[i] = data.get(i).getEnvironment();
        }
        return environments;
    }

    public String[] getLocalities() throws SQLException {
        List<Localities> data = mainModel.getLocality();
        String[] localities = new String[data.size()];

        for(int i = 0; i < data.size(); i++) {
            localities[i] = data.get(i).getLocalityName();
        }

        return localities;
    }

    public String[] getCardNumbers() throws SQLException {
        List<Cards> data = mainModel.getCard();
        String[] cardNumbers = new String[data.size()];

        for(int i = 0; i < data.size(); i++) {
            cardNumbers[i] = data.get(i).getCardNr();
        }

        return cardNumbers;
    }

    public void addData(DisplayData displayData) throws SQLException {
        mainModel.addData(displayData);
    }
}
