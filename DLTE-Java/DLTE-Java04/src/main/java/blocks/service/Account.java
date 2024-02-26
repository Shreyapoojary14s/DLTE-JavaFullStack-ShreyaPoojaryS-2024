package blocks.service;

public class Account {
    //inti
    String accountHolder="Shreya";
    Long accountNumber=50009632450L;
    Double accountBalance=1800100.50;

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }
}
