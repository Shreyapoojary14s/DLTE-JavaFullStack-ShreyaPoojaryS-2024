package blocks.service;

import java.util.Scanner;
import java.util.Date;

public class TransactionAnalysis {

    public class void main(String[] args){
        //initialization
        int choice;
        Scanner scanner=new Scanner((System.in);
        Transaction[] transaction={new Transaction(new Date(20,2,10),90080.0,"Shreya","Education"),
                new Transaction(new Date(20,5,20),80080.0,"Asha","Home"),
                new Transaction(new Date(20,3,14),70050.0,"Seetharama","shop"),
                new Transaction(new Date(20,7,27),89980.0,"Arun","Hospital")
        };
        //menus for update || sorting
        System.out.println(("Enter your Choice\n1.Analysis\n2.Sorting");
        choice = scanner.nextInt();
        TransactionAnalysis transactionAnalysis=new TransactionAnalysis();

        //sub
        if(choice==1){

        System.out.println("Enter your choice\n 1.Filter based on date\n2.least amount transferred\n3.Maximum amount transferred\n4.Number of transaction made for beneficiary\n5.basrd on remarks");
        int subMenu=scanner.nextInt();
        switch (subMenu){
            case 1:
                System.out.println("Enter start date");
                int startDate=scanner.nextInt();
                System.out.println("Enter stop date");
                int stopdate=scanner.nextInt();
                transactionAnalysis.filterDate(startDate,stopdate,transaction);
                break;
                //least amount
            case 2:transactionAnalysis.leastAmt(transaction);
                    break;
                    //max amount
            case 3:transactionAnalysis.leastAmount(transaction);
                break;
            case 4:
                System.out.println("Enter Beneficiary name");
                String beneficiaryName=scanner.next();
                transactionAnalysis.numberofTransactionbeneficiary(beneficiary,transaction);
                break;
            case 5:
                System.out.println("Enter the Remarks");
                String remarks=scanner.next();
                transactionAnalysis.filterOnRemarks(remarks,transaction);
                break;


        }
        else if(choice==2){
                System.out.println("1.Based on descending of beneficiary\n2.Based on amount transferred in ascending");
                int subChoice=scanner.nextInt();
                switch (subChoice){
                    case 1:transactionAnalysis.sortBen(transaction);
                            break;
                    case 2:transactionAnalysis.sortAmt(transaction);
                            break;

                }
            }
        public void leastAmt(Transaction transaction[]){
            double min = transaction[0].getAmountInTransaction();
            fot (Transaction each:transaction){
                if(each.getAmountInTransaction()<=min){
                    mim =each.getAmountIntransaction();
                }
                }
                System.out.println("least transaction is\t"+min);
            }
        public void filterDate(int startdate,int stopDate,Transactiont transaction[]){
            for(Transactiont each: transaction){
                if(each: getdateOfTransaction().getDate()>=startDate && each.getDateOfTransaction().getdate()<stopDate){
                    System.out.println("Transaction is done to "each.getTo()+"\t amount of "+amount"+each.getAmountTransaction());
                }
            }
            }

}
    }
