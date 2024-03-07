package block.service.task468;

import java.util.Date;

public class CreditCard {
    private  Long CreditNumber;
    private String cardHolder;
    private Date cardExpiry;
    private Integer cardCvv;
    private Integer cardLimit;
    private Date date;
    private Date dateOfBillPayment;
    private Integer cardPin;

    public CreditCard(Long creditNumber, String cardHolder, Date cardExpiry, Integer cardCvv, Integer cardLimit, Date date, Date dateOfBillPayment, Integer cardPin) {
        CreditNumber = creditNumber;
        this.cardHolder = cardHolder;
        this.cardExpiry = cardExpiry;
        this.cardCvv = cardCvv;
        this.cardLimit = cardLimit;
        this.date = date;
        this.dateOfBillPayment = dateOfBillPayment;
        this.cardPin = cardPin;
    }



    public Long getCreditNumber() {
        return CreditNumber;
    }

    public void setCreditNumber(Long creditNumber) {
        CreditNumber = creditNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Date getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(Date cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public Integer getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(Integer cardCvv) {
        this.cardCvv = cardCvv;
    }

    public Integer getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Integer cardLimit) {
        this.cardLimit = cardLimit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateOfBillPayment() {
        return dateOfBillPayment;
    }

    public void setDateOfBillPayment(Date dateOfBillPayment) {
        this.dateOfBillPayment = dateOfBillPayment;
    }

    public Integer getCardPin() {
        return cardPin;
    }

    public void setCardPin(Integer cardPin) {
        this.cardPin = cardPin;
    }
}
