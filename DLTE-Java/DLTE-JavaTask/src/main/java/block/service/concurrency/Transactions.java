package block.service.concurrency;

import java.util.Date;

public class Transactions {
    private Date dateTransaction;
    private Integer amount;
    private String to;
    private String remarks;

    public Transactions(Date dateTransaction, Integer amount, String to, String remarks) {
        this.dateTransaction = dateTransaction;
        this.amount = amount;
        this.to = to;
        this.remarks = remarks;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
