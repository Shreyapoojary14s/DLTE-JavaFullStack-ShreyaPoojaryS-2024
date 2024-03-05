package block.service;


import java.util.Date;

public class Transactions {
    private Date dateOfTransaction;
    private Integer amountInTransaction;
    private String toWhom;
    private String remarks;



    public Transactions(Date dateOfTransaction, Integer amountInTransaction, String toWhom, String remarks){
        this.amountInTransaction = amountInTransaction;
        this.toWhom = toWhom;
        this.remarks = remarks;
        this.dateOfTransaction=dateOfTransaction;

    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
       this.dateOfTransaction=dateOfTransaction;
    }

    public Integer getAmountInTransaction() {
        return amountInTransaction;
    }

    public void setAmountInTransaction(Integer amountInTransaction) {
        this.amountInTransaction = amountInTransaction;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
