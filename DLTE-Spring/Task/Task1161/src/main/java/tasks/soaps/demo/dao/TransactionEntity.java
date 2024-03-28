package tasks.soaps.demo.dao;

import java.util.Date;

//import java.util.Date;
public class TransactionEntity {
    private Long transaction_Id;
    private Date transaction_Date;
    private String transaction_To;
    private String transaction_from;
    private String transaction_amount;
    private String transaction_remarks;

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "transaction_Id=" + transaction_Id +
                ", transaction_Date=" + transaction_Date +
                ", transaction_To='" + transaction_To + '\'' +
                ", transaction_from='" + transaction_from + '\'' +
                ", transaction_amount=" + transaction_amount +
                ", transaction_remarks='" + transaction_remarks + '\'' +
                '}';
    }

    public TransactionEntity() {
        this.transaction_Id = transaction_Id;
        this.transaction_Date = transaction_Date;
        this.transaction_To = transaction_To;
        this.transaction_from = transaction_from;
        this.transaction_amount = transaction_amount;
        this.transaction_remarks = transaction_remarks;
    }

    public Long getTransaction_Id() {
        return transaction_Id;
    }

    public void setTransaction_Id(Long transaction_Id) {
        this.transaction_Id = transaction_Id;
    }

    public Date getTransaction_Date() {
        return transaction_Date;
    }

    public void setTransaction_Date(Date transaction_Date) {
        this.transaction_Date = transaction_Date;
    }

    public String getTransaction_To() {
        return transaction_To;
    }

    public void setTransaction_To(String transaction_To) {
        this.transaction_To = transaction_To;
    }

    public String getTransaction_from() {
        return transaction_from;
    }

    public void setTransaction_from(String transaction_from) {
        this.transaction_from = transaction_from;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_remarks() {
        return transaction_remarks;
    }

    public void setTransaction_remarks(String transaction_remarks) {
        this.transaction_remarks = transaction_remarks;
    }
}
