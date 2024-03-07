package block.service.concurrency;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionAnalysis implements Runnable {
        Lock execute=new ReentrantLock();
        Transactions[] transactions = {
                new Transactions(new Date(2021, 8, 24), 500, "Anajali", "Friend"),
                new Transactions(new Date(2020, 9, 12), 5000, "Deepa", "Family"),
                new Transactions(new Date(2022, 8, 03), 6500, "Ankush", "Education"),
                new Transactions(new Date(2024, 5, 15), 7000, "kader", "Bills"),
                new Transactions(new Date(2021, 8, 24), 50000, "Shreya", "Friend"),
        };
        public  void run() {
            //initiate lock
            execute.lock();
            TransactionAnalysis analysis = new TransactionAnalysis();
            int choice;
            Scanner scanner = new Scanner(System.in);
            //menu for transaction analysis
            while(true) {
                System.out.println("Choose:\n 1.Least amount transferred\n" + "2.Identify maximum transaction\n" + "3.Filtering based on remark\n" + "4.sort in descending on beneficiary \n" + "5.Sorting based on amount transferred ascending\n" + "6.Transaction to particular beneficiary\n 7.Range on dates");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        analysis.leastAmountTransferred(transactions);
                        return;
                    case 2:
                        analysis.MaxAmountTransferred(transactions);
                        return;
                    case 3:
                        analysis.FilteringBasedParticularRemark(transactions);
                        return;
                    case 4:
                        analysis.SortBeneficiary(transactions);
                        return;
                    case 5:
                        analysis.SortAmount(transactions);
                        return;
                    case 6:
                        analysis.transactionToParticularBeneficiary(transactions);
                        return;
                    case 7:
                        analysis.rangeBasedOnDates(transactions);
                        return;

                }
                //end lock
                execute.unlock();
            }

        }
        //range of transaction based on dates
        public void rangeBasedOnDates(Transactions[] transactions){
            String StartDateInput;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter start range date DD/MM/YYYY format");
            StartDateInput=scanner.next();
            String splitStartDate[]=StartDateInput.split("/");
            for(Transactions each: transactions){
                if((Integer.parseInt(splitStartDate[0])==(each.getDateTransaction()).getDate())&&(Integer.parseInt(splitStartDate[1])==(each.getDateTransaction()).getMonth())&&(Integer.parseInt(splitStartDate[2])==(each.getDateTransaction()).getYear())) {
                    System.out.println("Transaction on date "+(each.getDateTransaction()).getDate()+"to"+each.getTo());
                    System.out.println(each.getAmount());
                }

            }

        }
        //selection sort based on amount in ascending
    public void SortAmount(Transactions[] transactions){
        Transactions temporary=null;
        for(int index=0;index<transactions.length-1;index++){
            int minimumIndex=index;
            int minimumAmount=transactions[index].getAmount();
            for(int next=index+1;next<transactions.length;next++){
                if(transactions[next].getAmount()<minimumAmount){
                    minimumAmount=transactions[next].getAmount();
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

    //least money transferred by the person
        public void leastAmountTransferred(Transactions[] transactions){
            int leastAmounts=Integer.MAX_VALUE;
            for(Transactions each:transactions){
                int compareAmount=each.getAmount();
                if(compareAmount<leastAmounts){
                    leastAmounts=compareAmount;
                }
            }
            System.out.println("The least amount transfered is "+leastAmounts);
        }

        //maximum money transferred by the person
        public void MaxAmountTransferred(Transactions[] transactions){
            int MaxAmounts=Integer.MIN_VALUE;
            for(Transactions each:transactions){
                int compareAmount=each.getAmount();
                if(compareAmount>MaxAmounts){
                    MaxAmounts=compareAmount;
                }
            }
            System.out.println("The maximum amount transfered is "+MaxAmounts);
        }
        //transaction to particular beneficiary
        public void transactionToParticularBeneficiary(Transactions[] transactions){
            Scanner scanner=new Scanner(System.in);
            String Beneficiary;
            System.out.println("Enter beneficiary name");
            Beneficiary= scanner.next();
            int NumberOfTransaction=0;
            for(Transactions each:transactions){
                if(each.getTo().equals(Beneficiary)){
                    NumberOfTransaction++;
                }

            }
            System.out.println("Number of transaction to "+Beneficiary+"= "+NumberOfTransaction);
        }
        //filtering based on particular remark in transaction
        public void FilteringBasedParticularRemark(Transactions[] transactions){
            Scanner scanner=new Scanner(System.in);
            String Remark;
            System.out.println("Enter Remark");
            Remark= scanner.next();
            for(Transactions each:transactions){
                if(each.getRemarks().equals(Remark)){
                    System.out.println(each.getAmount()+" is the amount transferred to "+each.getTo()+" has remark "+Remark);
                }

            }

        }
        //selection sort based on Beneficiary in descending
        public void SortBeneficiary(Transactions[] transactions){
            Transactions temporary=null;
            for(int index=0;index<transactions.length-1;index++){
//                int maximumIndex=index;
//                String maximumString=transactions[index].getTo();
//                for(int next=index+1;next<transactions.length;next++){
//                    if(transactions[next].getTo().compareTo(maximumString)>0){
//                        maximumString=transactions[next].getTo();
//                        maximumIndex=next;
                int maximumIndex=index;
                String maximumString=transactions[index].getTo();
                for(int next=index+1;next<transactions.length;next++){
                    if(transactions[next].getTo().compareTo(maximumString)>0){
                        maximumString=transactions[next].getTo();
                        maximumIndex=next;
                    }
                }
                if(maximumIndex!=index){
                    temporary=transactions[maximumIndex];
                    transactions[maximumIndex]=transactions[index];
                    transactions[index]=temporary;

                }
//                if(maximumIndex=index){
//                    temporary=transactions[maximumIndex];
//                    transactions[maximumIndex]=transactions[index];
//                    transactions[index]=temporary;
//
//                }
            }
        }


}
