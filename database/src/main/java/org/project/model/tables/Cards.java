package org.project.model.tables;

import java.sql.Date;

public class Cards {
    private String cardNr;
    private String cardType;
    private Date dateExpire;

    public Cards(String cardNr, String cardType, Date dateExpire) {
        this.cardNr = cardNr;
        this.cardType = cardType;
        this.dateExpire = dateExpire;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }
}
