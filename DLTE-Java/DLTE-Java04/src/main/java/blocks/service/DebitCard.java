package blocks.service;

public class DebitCard extends Account{
    //public class Debitcard extends Account {
        Integer pinCard = 5665;
        Long cardNumber = 85236002504L;

        public boolean validatePin(Integer pin) {
            if (pinCard.equals(pin))
                return true;
            return false;
        }

        public void makeWithdraw(Double withdrawAmount) {
            if (super.getAccountBalance() - withdrawAmount >= 0) {
                super.setAccountBalance(super.getAccountBalance() - withdrawAmount);
                System.out.println("Money has been debited from\t" + getAccountNumber() + "\t,Your current balance is" + getAccountBalance());
                System.exit(0);
            } else {
                System.out.println("Insufficient fund");
            }
        }

    }

