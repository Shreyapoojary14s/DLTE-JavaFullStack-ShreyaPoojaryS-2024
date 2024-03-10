package block.service.task641;



import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
    public class TestClass implements MyBank {
        public ArrayList<Loan> loanInfo=new ArrayList<>();


        public static void main(String[] args) throws IOException, ClassNotFoundException {
            TestClass mainClass = new TestClass();


            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1) Add loan");
                System.out.println("2) List of the available loans");
                System.out.println("3) List closed loans availablr");
                System.out.println("4) Exit");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        //adding new loan
                        System.out.println("loan amount");
                        Double amount=scanner.nextDouble();
                        System.out.println("contact number");
                        Long contact=scanner.nextLong();
                        System.out.println("loan number");
                        Long loanNumber=scanner.nextLong();
                        System.out.println("borrower name");
                        String borrowerName=scanner.next();
                        System.out.println("Enter the date");
                        String date = scanner.next();
                        System.out.println("Status");
                        String status= scanner.next();
                        mainClass.addLoan(new Loan(loanNumber,amount,date,status,borrowerName,contact));
                        break;
                    case 2:
                        // Display available loans
                        mainClass.checkAvailableLoan();
                        break;
                    case 3:
                        // Checking closed loan
                        mainClass.getCheckClosedLoan();
                        break;
                    case 4:
                        System.out.println("Exiting");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        @Override
        public void addLoan(Loan loan) throws IOException, ClassNotFoundException {
            //readLoanFromFile();
            loanInfo.add(loan);
            System.out.println(" Added Successfully");
        }
        @Override
        public void checkAvailableLoan() throws IOException, ClassNotFoundException {
            System.out.println("Available Loans:");
            for(Loan each:loanInfo){
                if(each.getLoanStatus().equals("open")){
                    System.out.println(each);
                }
            }
        }

        @Override
        public void getCheckClosedLoan() throws IOException, ClassNotFoundException {
            System.out.println("Closed Loans");
            for(Loan each:loanInfo){
                if(each.getLoanStatus().equals("close")){
                    System.out.println(each);
                }

            }
        }


}
