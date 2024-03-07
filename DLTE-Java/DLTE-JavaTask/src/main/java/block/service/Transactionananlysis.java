package block.service;
import java.util.Date;
import java.util.Scanner;


public class Transactionananlysis implements Runnable {
    //sample data
    Transactions[] transactions={
            new Transactions(new Date(2022,5,20),30000,"Harshitha","Bakery"),
            new Transactions(new Date(2022,6,15),7400,"Srusthi","education"),
            new Transactions(new Date(2022,7,21),890,"Deepika","education"),
            new Transactions(new Date(2022,2,2),3151,"Shreya","party"),
            new Transactions(new Date(2023,5,8),521,"Soorkie","DJ"),
    };
    public void run(){
       Transactionananlysis customerAnalysis =new Transactionananlysis();
        int option;
        Scanner scanner=new Scanner(System.in);
        while(true){
            //menu
            System.out.println("Transaction Analysis:");
            System.out.println("Enter your choice:\n1.Least amount transferred\n2.Transaction of particular beneficiary\n3.filter based on remarks\n4.Sort based on amount transferred\n5.maximum amount transaction");
            option=scanner.nextInt();
            //different cases
            switch(option){
                case 1: customerAnalysis.leastAmountTransferred(transactions);
                return;
                case 2:
                    customerAnalysis.transactionToParticularBeneficiary(transactions);
                    return;
                case 3:
                    customerAnalysis.filterBasedParticularRemark(transactions);
                    return;
                case 4:
                    customerAnalysis.sortAmount(transactions);
                    return;
                case 5:
                    customerAnalysis.maxAmountTransferred(transactions);
                    return;
                default:System.exit(0);


            }
        }

    }
    public void displayTransactionToWhom(){
        System.out.println("For whom money sent");
        for(Transactions each:transactions){
            System.out.println(each.getToWhom());
        }
    }
    public void displayAllRemarks(){
        System.out.println("Remarks in the transaction");
        for(Transactions each:transactions){
            System.out.println(each.getRemarks());
        }
    }
    public void displayAllAmount(){
        System.out.println("Amount transfered");
        for(Transactions each:transactions){
            System.out.println(each.getAmountInTransaction());
        }
    }

//least amount
    public void leastAmountTransferred(Transactions[] transactions){
        int leastAmounts=Integer.MAX_VALUE;
        for(Transactions each:transactions){
            int compareAmount=each.getAmountInTransaction();
            if(compareAmount<leastAmounts){
                leastAmounts=compareAmount;
            }

        }
        System.out.println("Least amount transfer is\t:"+leastAmounts);
      System.exit(0);
    }
//max amount
    public void maxAmountTransferred(Transactions[] transactions){
        int MaxAmounts= Integer.MAX_VALUE;
        for(Transactions each:transactions){
            int compareAmount=each.getAmountInTransaction();
            if(compareAmount>MaxAmounts){
                MaxAmounts=compareAmount;
            }

        }
        System.out.println("Maximum amount transfer is"+MaxAmounts);
        System.exit(0);
    }
    //particular beneficiary
    public void transactionToParticularBeneficiary(Transactions[] transactions){
        Scanner scanner = new Scanner(System.in);
        String Beneficiary;
        System.out.println("Enter Name");
        Beneficiary=scanner.next();
        int NumberOfTransaction=0;
        for(Transactions each:transactions){
            if(each.getToWhom().equals(Beneficiary)){
                NumberOfTransaction++;
            }
        }
        System.out.println("Number of transaction to \t"+Beneficiary+"=" +NumberOfTransaction);
        System.exit(0);

    }

    //remark
    public  void  filterBasedParticularRemark(Transactions[] transactions){
        Scanner scanner = new Scanner(System.in);
        String Remark;
        System.out.println("Enter Remark");
        Remark=scanner.next();
        for(Transactions each:transactions){
            if(each.getRemarks().equals(Remark)){
                System.out.println(each.getAmountInTransaction()+"\t is transfered to\t"+each.getToWhom()+",for"+Remark);
                System.exit(0);
            }
        }
    }
//sort on amount
    public void sortAmount(Transactions[] transactions){
        Transactions temporary=null;
        for(int index=0;index<transactions.length-1;index++){
            int minimumIndex=index;
            int minimumAmount=transactions[index].getAmountInTransaction();
            for(int next=index+1;next<transactions.length;next++){
                if(transactions[next].getAmountInTransaction()<minimumAmount){
                    minimumAmount=transactions[next].getAmountInTransaction();
                    minimumIndex=next;
                }
            }
           if(minimumIndex!=index){
               temporary=transactions[minimumIndex];
               transactions[minimumIndex]=transactions[index];
               transactions[index]=temporary;
           }
        }
    }
}
