package org.project.entity;

public class DisplayData extends Beneficiaries {
    private String localityName;
    private String cardNumber;

    public DisplayData(String codeBen, String nameBen, String surnameBen, String phoneBen, String IDNP, String addressBen, String emailBen, String localityName, String environment, String cardNumber) {
        super(codeBen, nameBen, surnameBen, phoneBen, IDNP, addressBen, emailBen);
        this.localityName = localityName;
        this.cardNumber = cardNumber;
    }

    public DisplayData(int ID, String codeBen, String nameBen, String surnameBen, String phoneBen, String IDNP, String addressBen, String emailBen, int localityID, String localityName, String environment, int cardID, String cardNumber) {
        super(ID, codeBen, nameBen, surnameBen, phoneBen, IDNP, addressBen, emailBen, localityID, environment, cardID);
        this.localityName = localityName;
        this.cardNumber = cardNumber;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "DisplayData{" + "localityName='" + localityName + '\'' + ", cardNumber='" + cardNumber + '\'' + '}';
    }
}
