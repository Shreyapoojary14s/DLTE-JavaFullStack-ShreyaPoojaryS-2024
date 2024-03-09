/*//*package block.service.task739;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static block.service.task739.Loan.loanmust;

public class MyLoan {
    public static void main(String[] args) {
        MyLoan customers = new MyLoan();
        LoanProduct loan1 = new Loan(545454545L, 5000L, new Date("1/02/2002"), "Open", "SHREYA", 8523632852L);
        LoanProduct loan2 = new Loan(6074899222L, 8000L, new Date("10/06/2003"), "OPEN", "HaRSHITHA", 9632565247L);
        LoanProduct loan3 = new Loan(123456987L, 9000L, new Date("15/07/2003"), "Close", "VIJAY", 8545644857L);
        loanmust.addAll(Stream.of(loan1, loan2,loan3).collect(Collectors.toList()));
        Loan filter = ((startDate, endDate) -> {
            for (Loan each : loanmust) {
                if (each.getLoanDate().after(startDate) && each.getLoanDate().before(endDate)) {
                    System.out.println(each);
                }

            }
        });
//interface filterDate
        System.out.println("Enter the start date;");
        Scanner scanner=new Scanner(System.in);
        Date start=new Date(scanner.next());
        System.out.println("Enter the end date");
        Date end=new Date(scanner.next());
        filter.filterDate(start,end);



    }
//    @Override
//    public void filterByDate() {
//
//
//    }
}
*/