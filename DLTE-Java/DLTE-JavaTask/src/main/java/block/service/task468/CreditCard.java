package block.service.task468;

import java.util.Date;

public class CreditCard {
//    private  Long CreditNumber;
//    private String cardHolder;
//    private Date cardExpiry;
//    private Integer cardCvv;
//    private Integer cardLimit;
//    private Date date;
//    private Date dateOfBillPayment;
//    private Integer cardPin;

    private Long cardNumber;
    private String cardHolder;
    private Date cardExpiry;
    private Integer cardCvv;
    private Integer cardLimit;
    private Date dateOfBillGenearation;
    private Date dateOfBillPayment;
    private Integer creditCardPin;

    public CreditCard(Long cardNumber, String cardHolder, Date cardExpiry, Integer cardCvv, Integer cardLimit, Date dateOfBillGenearation, Date dateOfBillPayment, Integer creditCardPin) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cardExpiry = cardExpiry;
        this.cardCvv = cardCvv;
        this.cardLimit = cardLimit;
        this.dateOfBillGenearation = dateOfBillGenearation;
        this.dateOfBillPayment = dateOfBillPayment;
        this.creditCardPin = creditCardPin;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
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

    public Date getDateOfBillGenearation() {
        return dateOfBillGenearation;
    }

    public void setDateOfBillGenearation(Date dateOfBillGenearation) {
        this.dateOfBillGenearation = dateOfBillGenearation;
    }

    public Date getDateOfBillPayment() {
        return dateOfBillPayment;
    }

    public void setDateOfBillPayment(Date dateOfBillPayment) {
        this.dateOfBillPayment = dateOfBillPayment;
    }

    public Integer getCreditCardPin() {
        return creditCardPin;
    }

    public void setCreditCardPin(Integer creditCardPin) {
        this.creditCardPin = creditCardPin;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", cardHolder='" + cardHolder + '\'' +
                ", cardExpiry=" + cardExpiry +
                ", cardCvv=" + cardCvv +
                ", cardLimit=" + cardLimit +
                ", dateOfBillGenearation=" + dateOfBillGenearation +
                ", dateOfBillPayment=" + dateOfBillPayment +
                ", creditCardPin=" + creditCardPin +
                '}';
    }
}
