package blocks.service;

import java.util.Scanner;
import java.util.Date;

public class TransactionAnalysis {

    public static void main(String[] args) {
        //initialization
        int choice;
        Scanner scanner = new Scanner(System.in);
        Transaction[] transaction = {new Transaction(new Date(20, 2, 10), 90080.0, "Shreya", "Education"),
                new Transaction(new Date(20, 5, 20), 80080.0, "Asha", "Home"),
                new Transaction(new Date(20, 3, 14), 70050.0, "Seetharama", "shop"),
                new Transaction(new Date(20, 7, 27), 89980.0, "Arun", "Hospital"),
        };
        //menus for update || sorting
        System.out.println("Enter your Choice\n1.Analysis\n2.Sorting");
        choice = scanner.nextInt();
        TransactionAnalysis transactionAnalysis = new TransactionAnalysis();

        //sub
        if (choice == 1) {

            System.out.println("Enter your choice\n 1.Filter based on date\n2.least amount transferred\n3.Maximum amount transferred\n4.Number of transaction made for beneficiary\n5.basrd on remarks");
            int subMenu = scanner.nextInt();
            switch (subMenu) {
                case 1:
                    System.out.println("Enter start date");
                    int startDate = scanner.nextInt();
                    System.out.println("Enter stop date");
                    int stopDate = scanner.nextInt();
                    transactionAnalysis.filterDate(startDate, stopDate, transaction);
                    break;
                //least amount
                case 2:
                    transactionAnalysis.leastAmt(transaction);
                    break;
                //max amount
                case 3:
                    transactionAnalysis.maxAmt(transaction);
                    break;
                case 4:
                    System.out.println("Enter Beneficiary name");
                    String beneficiaryName = scanner.next();
                    transactionAnalysis.numberOfTransactionBeneficiary(beneficiaryName, transaction);
                    break;
                case 5:
                    System.out.println("Enter the Remarks");
                    String remarks = scanner.next();
                    transactionAnalysis.filterRemarks(remarks, transaction);
                    break;


            }
        } else if (choice == 2) {
            System.out.println("1.Based on descending of beneficiary\n2.Based on amount transferred in ascending");
            int subChoice = scanner.nextInt();
            switch (subChoice) {
                case 1:
                    transactionAnalysis.sortBen(transaction);
                    break;
                case 2:
                    transactionAnalysis.sortAmt(transaction);
                    break;

            }
        }
    }
        public void filterDate(int startDate,int stopDate, Transaction transaction[]){
            for(Transaction each: transaction){
                if(each.getDateOfTransaction().getDate()>=startDate && each.getDateOfTransaction().getDate()<stopDate){
                    System.out.println("Transaction is done to "+each.getTo()+"\t amount of "+ each.getAmountInTransaction());
                }
            }
        }

        public void leastAmt(Transaction transaction[]){
            double min = transaction[0].getAmountInTransaction();
            for (Transaction each:transaction){
                if(each.getAmountInTransaction()<=min){
                    min =each.getAmountInTransaction();
                }
                }
                System.out.println("least transaction is\t"+min);
            }
            public void maxAmt(Transaction transaction[]){
                double max = transaction[0].getAmountInTransaction();
                for (Transaction each:transaction){
                    if(each.getAmountInTransaction()>=max){
                        max=each.getAmountInTransaction();
                    }
                }
                System.out.println("Maximum transaction is\t"+max);
            }


        public void  numberOfTransactionBeneficiary(String beneficiaryName,Transaction transaction[]){
            int count=0;
            for(Transaction each:transaction){
                if(each.getTo().equalsIgnoreCase(beneficiaryName)){
                    count++;
                }

                }
                System.out.println(count);
            }
        public void filterRemarks(String remarks,Transaction transaction[]){
                for(Transaction each :transaction){
                   // if(int i=0;i<transaction.length-1;i++){
                //}
                    if(each.getRemarks().equalsIgnoreCase(remarks)){
                        System.out.println(each.toString());
                    }

            }
            }
            public void sortBen(Transaction transaction[]){
            Transaction temp;
            for(int i=0;i<transaction.length-1;i++){
                for(int j=i+1;j<transaction.length-1;j++){
                    if(transaction[i].getTo().compareTo(transaction[j].getTo())<0){
                        temp = transaction[i];
                        transaction[i]=transaction[j];
                        transaction[j]=temp;
                    }
                }
            }
                for(Transaction each :transaction)  {
                    System.out.println(each.toString());
                }
            }


            public void sortAmt(Transaction transaction[]){
                Transaction temp;
                for(int i=0;i<transaction.length-1;i++){
                    for(int j=i+1;j<transaction.length-1;j++){
                        if(transaction[i].getAmountInTransaction().compareTo(transaction[j].getAmountInTransaction())>0){
                            temp=transaction[i];
                            transaction[i]=transaction[j];
                            transaction[j]=temp;
                        }
                    }
                }
                for(Transaction each :transaction)  {
                    System.out.println(each.toString());
                }
            }




    }
