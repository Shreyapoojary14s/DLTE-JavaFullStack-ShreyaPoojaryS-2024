package block.service.task575;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DynamicStorage {
    static ArrayList<Transactions> transactionsList = new ArrayList<>();
    public static void main(String[] args) {
      // Transactions transactions1 = new Transactions(new Date("05/20/2024"), 50, "Prabhanjan", "Friend");
            Transactions transactions1 = new Transactions(new Date("05/20/2024"), 50, "Prabhanjan", "Friend");
            Transactions transactions2 = new Transactions(new Date("09/20/2024"), 550, "Shobhit", "Education");
            Transactions transactions3 = new Transactions(new Date("05/28/2024"), 9500, "Shreya", "Education");
            Transactions transactions4 = new Transactions(new Date("08/15/2024"), 1200, "harshitha", "hostel");
            Transactions transactions5 = new Transactions(new Date("01/01/2024"), 96000, "Kumar", "Friend");
            transactionsList = (ArrayList<Transactions>) Stream.of(transactions1, transactions2, transactions3, transactions4, transactions5).collect(Collectors.toList());
            int option;
            Scanner scanner = new Scanner(System.in);
            //menu
            while (true) {
                System.out.println("1)Least amount transferred\n" + "2)Maximum amount transferred\n" + "3)Filtering based on date\n" + "4)Sort in descending on beneficiary \n");
                option= scanner.nextInt();
              //menu
                switch (option) {
                    case 1:
                        leastAmountTransferred();
                        break;
                    case 2:
                        maximumAmountTransferred();
                        break;
                    case 3:
                        System.out.println("Enter the start range date:");
                        Date startDate=new Date(scanner.next());
                        System.out.println("Enter the start range date :");
                        Date endDate=new Date(scanner.next());
                        rangeOfDate(startDate,endDate);
                        break;
                    case 4:
                        //enter property and order
                        System.out.println("To sort based on choice enter property:order (no space)");
                        String propertyOrder=scanner.next();
                        TransactionComparator compare=new TransactionComparator(propertyOrder);
                        Collections.sort(transactionsList,compare);
                        transactionsList.forEach(System.out::println);
                        break;

                }

            }

        }
        //range
        public static void rangeOfDate(Date start,Date end) {
        Transactions leastTransaction = transactionsList.stream().max(Comparator.comparingDouble(Transactions::getAmountInTransaction)).orElse(null);
        System.out.println("Maximum amount transferred = "+leastTransaction.getAmountInTransaction());
        List<Transactions> rangeByDateList = transactionsList.stream().filter(each->each.getDateOfTransaction().after(start)&&each.getDateOfTransaction().before(end)).collect(Collectors.toList());
        rangeByDateList.forEach(Transactions->{
            System.out.println(Transactions.toString());
        } );
    }
    //Least amount
        public static void leastAmountTransferred() {
            Transactions leastTransaction = transactionsList.stream().min(Comparator.comparingDouble(Transactions::getAmountInTransaction)).orElse(null);
            System.out.println("Least amount transferred = "+leastTransaction.getAmountInTransaction());
        }
        //Maximum
        public static void maximumAmountTransferred() {
            Transactions leastTransaction = transactionsList.stream().max(Comparator.comparingDouble(Transactions::getAmountInTransaction)).orElse(null);
            System.out.println("Maximum amount transferred = "+leastTransaction.getAmountInTransaction());
        }


}
