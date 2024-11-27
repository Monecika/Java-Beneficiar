package org.project.main.components.table;

import org.project.entity.DisplayData;

import javax.swing.*;
import java.awt.*;

public class AddBenOptionPane {
    private final JTextField name;
    private final JTextField surname;
    private final JTextField address;
    private final JTextField phone;
    private final JTextField IDNP;
    private final JTextField email;
    private final JLabel information;
    private final JLabel nameLabel;
    private final JLabel surnameLabel;
    private final JLabel addressLabel;
    private final JLabel documentsLabel;
    private final JLabel phoneLabel;
    private final JLabel IDNPLabel;
    private final JLabel environmentLabel;
    private final JLabel localityLabel;
    private final JLabel cardLabel;
    private final JLabel emailLabel;
    private final JPanel panelOff;
    private final JComboBox environment;
    private final JComboBox locality;
    private final JComboBox card;
    private int result;

    public AddBenOptionPane(JComboBox environment, JComboBox locality, JComboBox card) {

        name = new JTextField(30);
        surname = new JTextField(30);
        address = new JTextField(30);
        phone = new JTextField(30);
        IDNP = new JTextField(30);
        this.environment = environment;
        this.locality = locality;
        this.card = card;
        email = new JTextField(30);

        information = new JLabel("Information");
        nameLabel = new JLabel("Name");
        surnameLabel = new JLabel("Surname");
        addressLabel = new JLabel("Address");
        documentsLabel = new JLabel("Documents");
        phoneLabel = new JLabel("Phone");
        IDNPLabel = new JLabel("IDNP");
        environmentLabel = new JLabel("Environment");
        localityLabel = new JLabel("Locality");
        cardLabel = new JLabel("Card");
        emailLabel = new JLabel("Email");

        panelOff = addValues();
        AddBenOption();
    }

    public void AddBenOption() {
        result = JOptionPane.showConfirmDialog(null, panelOff, "Add Ben", JOptionPane.OK_CANCEL_OPTION);
    }

    private JPanel addValues() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(information, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(surnameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(surname, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(address, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(documentsLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(IDNP, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(phone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(environmentLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(environment, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(localityLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(locality, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(cardLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(card, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(email, gbc);

        return panel;
    }

    public DisplayData getData() {
        DisplayData displayData = null;
        if (result == JOptionPane.OK_OPTION) {
            displayData = new DisplayData("", getName(), getSurname(), getPhone(), getIDNP(), getAddress(), getEmail(), getLocality(), getEnvironment(), getCard());
            System.out.println(displayData.toString());
        }
        return displayData;
    }

    public String getName() {
        return name.getText();
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getPhone() {
        return phone.getText();
    }

    public String getIDNP() {
        return IDNP.getText();
    }

    public String getEnvironment() {
        return environment.getSelectedItem().toString();
    }

    public String getLocality() {
        return locality.getSelectedItem().toString();
    }

    public String getCard() {
        return card.getSelectedItem().toString();
    }

    public String getEmail() {
        return email.getText();
    }

    public int getResult() {
        return result;
    }
}
