package blocks.service;

public class Gpay extends DebitCard{
    //init
    String billName="Siri";
    Integer pinsecond=779696;
    String billerType="Savings";
    //validation
    public boolean validatePin(Integer secondPin){
        if(pinsecond.equals(secondPin))
            return true;
        return false;
    }
    //payments
    public void makePayment(Double paymentAmount) {
        if (super.getAccountBalance() - paymentAmount >= 0) {
            super.setAccountBalance(super.getAccountBalance() - paymentAmount);
            System.out.println("Amount has been transferred from\t"+ getAccountNumber() + ".\tRemaining balance is" + getAccountBalance());
            System.exit(0);
        } else {
            System.out.println("Insufficient fund");
        }


    }
}
