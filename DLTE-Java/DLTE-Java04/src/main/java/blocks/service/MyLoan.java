package blocks.service;

//import java.util.Date;
import java.util.Scanner;
    public class MyLoan implements Loan {

        Long loanNumber;
        Double loanAmount;
        Integer loanDate;
        String loanStatus, borrowerName;
        Long borrowerContact;
        static int numberLoans;
        static int choice;
        //MyLoan myLoans[]=new MyLoan[30];
        LoanProducts loanProducts[] = new LoanProducts[30];

        public static void main(String[] args) {
            MyLoan myLoan = new MyLoan();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("enter your choice:1.Add loan2.Check balance3.Check closed loans");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the no.loans required");
                        numberLoans = scanner.nextInt();
                        myLoan.addLoans();
                        break;
                    case 2:
                        myLoan.checkLoans();
                        break;
                    case 3:
                        myLoan.closedLoans();
                        break;
                }
            }
        }

        public void addLoans() {
            Scanner scanner = new Scanner(System.in);
            for (int loans = 0; loans < numberLoans; loans++) {
                System.out.println("Enter amount");
                loanAmount = scanner.nextDouble();
                System.out.println("Enter Loan number");
                loanNumber = scanner.nextLong();
                System.out.println("Enter the loan date");
                loanDate = scanner.nextInt();
                System.out.println("enter borrower name");
                borrowerName = scanner.next();
                System.out.println("enter Mobile Number");
                borrowerContact = scanner.nextLong();
                loanProducts[loans] = new LoanProducts(loanNumber, loanDate, loanAmount, loanStatus, borrowerName, borrowerContact);


            }
            System.out.println("Loans added ");
        }



        public void checkLoans() {
            try {
                for (LoanProducts each : loanProducts) {
                    if (each.getLoanStatus().equalsIgnoreCase("open")) {
                        System.out.println(each.toString());
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
//@Override
        public void closedLoans() {
    try {
        for (LoanProducts each : loanProducts) {
            if (each.getLoanStatus().equalsIgnoreCase("open")) {
                System.out.println(each.toString());
            }
        }
    } catch (Exception e) {
    }
}
    }

