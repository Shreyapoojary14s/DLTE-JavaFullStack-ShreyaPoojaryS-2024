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
    };
    public void run(){
       Transactionananlysis customerAnanlysis =new Transactionananlysis();
        int option;
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("Transaction Analysis:");
            System.out.println("Enter your choice:\n1.Least amount transferred\n2.Transaction of particular beneficiary\n3.filter based on remarks\n4.Sort based on amount transferred\n5.maximum amount transaction");
            option=scanner.nextInt();
            //different cases
            switch(option){
                case 1: customerAnanlysis.leastAmountTransferred(transactions);
                return;
                case 2:
                    customerAnanlysis.transactionToParticularBeneficiary(transactions);
                    return;
                case 3:
                    customerAnanlysis.filterBasedParticularRemark(transactions);
                    return;
                case 4:
                    customerAnanlysis.sortAmount(transactions);
                    return;
                case 5:
                    customerAnanlysis.maxAmountTransferred(transactions);
                    return;
                default:System.exit(0);


            }
        }

    }
//    public void displayTransactionToWhom(){
//        System.out.println("All the names to whom money is send");
//        for(Transactions each:transactions){
//            System.out.println(each.getToWhom());
//        }
//    }
//    public void displayAllRemarks(){
//        System.out.println("All the Remarks in transaction");
//        for(Transactions each:transactions){
//            System.out.println(each.getRemarks());
//        }
//    }
//    public void displayAllAmount(){
//        System.out.println("All amount transfered");
//        for(Transactions each:transactions){
//            System.out.println(each.getAmountInTransaction());
//        }
//    }
//
//    public void RangeBasedOnDates(Transactions[] transactions){
//        String StartDateInput;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter start range date dd/mm/yyyy format");
//        StartDateInput = scanner.next();
//        String splitStartDate[]=StartDateInput.split("/");
//        for(Transactions each:transactions){
//            if((Integer.parseInt(splitStartDate[0])==(each.getDateOfTransaction()).getDate())&&(Integer.parseInt(splitStartDate[1])==(each.getDateOfTransaction()).getMonth())&&(Integer.parseInt(splitStartDate[2])==(each.getDateOfTransaction()).getYear())){
//                System.out.println("Transaction on date " +(each.getDateOfTransaction()).getDate()+"to"+each.getToWhom());
//                System.out.println(each.getAmountInTransaction());
//            }
//        }
//    }
//leasrt amount
    public void leastAmountTransferred(Transactions[] transactions){
        int leastAmounts=Integer.MAX_VALUE;
        for(Transactions each:transactions){
            int compareAmount=each.getAmountInTransaction();
            if(compareAmount<leastAmounts){
                leastAmounts=compareAmount;
            }

        }
        System.out.println("The least amount transfered is"+leastAmounts);
      System.exit(0);
    }
//max amount
    public void maxAmountTransferred(Transactions[] transactions){
        int MaxAmounts=Integer.MAX_VALUE;
        for(Transactions each:transactions){
            int compareAmount=each.getAmountInTransaction();
            if(compareAmount>MaxAmounts){
                MaxAmounts=compareAmount;
            }

        }
        System.out.println("The least amount transfered is"+MaxAmounts);
        System.exit(0);
    }
    //particular beneficiary
    public void transactionToParticularBeneficiary(Transactions[] transactions){
        Scanner scanner = new Scanner(System.in);
        String Beneficiary;
        System.out.println("Enter beneficary name");
        Beneficiary=scanner.next();
        int NumberOfTransaction=0;
        for(Transactions each:transactions){
            if(each.getToWhom().equals(Beneficiary)){
                NumberOfTransaction++;
            }
        }
        System.out.println("Number of transaction to"+Beneficiary+"=" +NumberOfTransaction);
        System.exit(0);

    }

    //remark
    public  void  filterBasedParticularRemark(Transactions[] transactions){
        Scanner scanner = new Scanner(System.in);
        String Remark;
        System.out.println("Enter remark");
        Remark=scanner.next();
        for(Transactions each:transactions){
            if(each.getRemarks().equals(Remark)){
                System.out.println(each.getAmountInTransaction()+"is the amount transfered to"+each.getToWhom()+"has remark"+Remark);
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
