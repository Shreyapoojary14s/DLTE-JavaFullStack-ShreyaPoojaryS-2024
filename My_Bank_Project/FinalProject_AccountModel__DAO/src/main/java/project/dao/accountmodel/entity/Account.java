package project.dao.accountmodel.entity;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class Account {
    private Long accountId;
    @NotNull(message= "{account.accountnumber.null}")
    @Range(min = 100000000000L, max = 999999999999L,message = "{accountnumber.max}")
    @Digits(integer=12,fraction=0,message="{account.number.limit}")
    private Long accountNumber;
    @Digits(message = "{customer.id.digits}", integer = 10, fraction =0 )
    private  Long customerId;
    @Pattern(regexp = "^(savings|salary|current)$", message = "{account.type.invalid}")
    @NotNull(message= "{account.type.null}")
    private String accountType;
    private String accountStatus;
    @Digits(integer=10,fraction=0,message="{account.balance.limit}")
    @NotNull(message= "{account.balance.null}")
    private  Double accountBalance;

    public Account() {

    }



    public Account(@NotNull(message = "{account.accountnumber.null}") @Digits(integer = 12, fraction = 0, message = "{account.number.null}") Long accountNumber, @NotNull(message = "{account.customerid.null}") Long customerId, @NotNull(message = "{account.type.null}") String accountType, @NotNull(message = "{account.balance.null}") Double accountBalance) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", customerId=" + customerId +
                ", accountType='" + accountType + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Account(@NotNull(message = "{account.id.null}") Long accountId, @NotNull(message = "{account.accountnumber.null}") @Digits(integer = 12, fraction = 0, message = "{account.number.null}") Long accountNumber, @NotNull(message = "{account.customerid.null}") Long customerId, @NotNull(message = "{account.type.null}") String accountType, @NotNull(message = "{account.status.null}") String accountStatus, @NotNull(message = "{account.balance.null}") Double accountBalance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
    }
}
