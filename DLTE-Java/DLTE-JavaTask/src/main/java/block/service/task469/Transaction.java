package block.service.task469;

import java.util.Date;

public class Transaction {  private Date dateOfTransaction;
    private Double amountInTransaction;
    private String transactionTo;
    private String remarks;

    @Override
    public String toString() {
        return "Transaction{" +
                "dateOfTransaction=" + dateOfTransaction +
                ", amountInTransaction=" + amountInTransaction +
                ", transactionTo='" + transactionTo + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Transaction() {
    }

    public Transaction(Date dateOfTransaction, Double amountInTransaction, String transactionTo, String remarks) {
        this.dateOfTransaction = dateOfTransaction;
        this.amountInTransaction = amountInTransaction;
        this.transactionTo = transactionTo;
        this.remarks = remarks;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public Double getAmountInTransaction() {
        return amountInTransaction;
    }

    public void setAmountInTransaction(Double amountInTransaction) {
        this.amountInTransaction = amountInTransaction;
    }

    public String getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(String transactionTo) {
        this.transactionTo = transactionTo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
