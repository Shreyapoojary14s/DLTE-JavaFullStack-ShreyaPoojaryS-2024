package block.service.task637;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankLoan implements  MyBank{
        ArrayList<LoanEntity> loansEntity=loan;
        @Override
        public void writeIntoFile() throws IOException {
            FileOutputStream fileOutputStream=new FileOutputStream("LoanDB.doc");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(loansEntity);
            fileOutputStream.close();
            objectOutputStream.close();
        }

        @Override
        public void readFromFile() throws IOException, ClassNotFoundException {

            FileInputStream fileInputStream=new FileInputStream("LoanDB.doc");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            loansEntity= (ArrayList<LoanEntity>) objectInputStream.readObject();

        }

        @Override
        public void addNewLoan(LoanEntity loan) {
            try {
                readFromFile();
            }
            catch (IOException|ClassNotFoundException E){

                System.out.println(E);
            }
            loansEntity.add(loan);

            try {
                writeIntoFile();
            }
            catch (IOException E){

                System.out.println(E);
            }

        }

        @Override
        public void checkAvailability() {
            try{
                readFromFile();
            }
            catch (IOException|ClassNotFoundException E){

                System.out.println(E);
            }
            List<LoanEntity> avail=loansEntity.stream().filter(each->each.getLoanStatus().equals("Open")).collect(Collectors.toList());
            avail.forEach(Loan->{
                System.out.println(Loan.toString());
            });
        }


        @Override
        public void checkClosedLoan() {
            try {
                readFromFile();
            }
            catch (IOException|ClassNotFoundException E){

                System.out.println(E);
            }
            List<LoanEntity> notAvail=loansEntity.stream().filter(each->each.getLoanStatus().equals("Close")).collect(Collectors.toList());
            notAvail.forEach(Loan->{
                System.out.println(Loan.toString());
            });
        }
        public LoanEntity getInputData(){
            System.out.println("Enter the Details:");
            long loanNumber;
            String borrowerName;
            Long borrowerContact;
            long loanAmount;
            String loanStatus;
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the loan number");
            loanNumber=scanner.nextLong();
            System.out.println("Enter the loan amount");
            loanAmount= scanner.nextInt();
            Date loanDate=new Date();
            System.out.println("Loan status");
            loanStatus=scanner.next();
            System.out.println("Enter the borrowers name");
            borrowerName=scanner.next();
            System.out.println("Enter the borrowers contact");
            borrowerContact=scanner.nextLong();
            return new LoanEntity(loanNumber,loanAmount,loanDate,loanStatus,borrowerName,borrowerContact);
        }

        public static void main(String[] args) {
            BankLoan customers=new BankLoan();

            LoanEntity  loanOne=new LoanEntity(7852121L,8520L,new Date(2024,01,25),"Open","Asha",9889632158L);
            LoanEntity  loanTwo=new LoanEntity(11111111L,963300L,new Date(2024,02,06),"Close","Siri",8520485236L);
            loan.addAll(Stream.of(loanOne,loanTwo).collect(Collectors.toList()));
            try {
                customers.writeIntoFile();
            }
            catch (IOException E){

                System.out.println(E);
            }
            Scanner scanner=new Scanner(System.in);
            while (true){
                System.out.println("1.Add loan details");
                System.out.println("2.check available loans");
                System.out.println("3.closed loans");
                int option=0;
                option=scanner.nextInt();
                switch(option){
                    case 1:customers.addNewLoan(customers.getInputData());
                        break;
                    case 2:customers.checkAvailability();
                        break;
                    case 3:customers.checkClosedLoan();
                        break;
                    default:System.exit(0);
                }
            }
        }
}

