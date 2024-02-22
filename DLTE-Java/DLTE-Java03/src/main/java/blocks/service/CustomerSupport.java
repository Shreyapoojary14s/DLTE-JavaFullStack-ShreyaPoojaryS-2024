package blocks.service;
import java.util.Date;
import java.util.Scanner;


public class CustomerSupport {

    public static void main(String[] args) {
        //   CreditCard[] myBank=new CreditCard[10];
        // Creditcard[]
        //Initialization
        Scanner scanner = new Scanner(System.in);
        CreditCardAnalysis[] myBank = {
                new CreditCardAnalysis(987656787656L, "Harshitha", new Date(2022, 12, 20), 552, 100500, new Date(2018, 3, 11), new Date(20, 03, 30), 9811),
                new CreditCardAnalysis(58765678765678L, "Prangi", new Date(2018, 05, 12), 200, 250000, new Date(2000, 3, 11), new Date(2000, 03, 30), 1181),
                new CreditCardAnalysis(5468765678765672L, "Nessara", new Date(2034, 12, 30), 555, 100000, new Date(2024, 3, 11), new Date(2024, 03, 30), 5211),
                new CreditCardAnalysis(115678765678L, "Shanth", new Date(2030, 05, 30), 963, 8000, new Date(2020, 04, 11), new Date(2020, 05, 22), 9658),
                new CreditCardAnalysis(5965678765671L, "Asha", new Date(2031, 02, 30), 595, 800000, new Date(2023, 03, 11), new Date(2023, 03, 30), 1111),
              //  new CreditCardAnalysis(6665678765678L, "Shreya", new Date(2025, 07, 15), 455, 308000, new Date(2021, , 24), new Date(2020, 09, 14), 9651),
                new CreditCardAnalysis(75856787650215L, "Siri", new Date(2014, 12, 23), 859, 100000, new Date(2011, 07, 28), new Date(2010, 11, 29), 8611)
        };
        //menu
        System.out.println("Enter the choice:\n1.Analysis\n2.Update");
        int choice, subOption;
        choice = scanner.nextInt();
        CustomerSupport support = new CustomerSupport();

        //filter
        switch (choice) {
            case 1:
                System.out.println("Enter your choice:\n1.Filter based on given limit \n2.filter based on date of bill payment");
                subOption = scanner.nextInt();
                support.filter(subOption, myBank);
                break;

            case 2:
                System.out.println("Enter your choice:\n1.Update specific PIN of customer\n2.Update the limit of customer those date of bill ganeration is 05th");
                subOption = scanner.nextInt();
                support.update(subOption, myBank);
                break;
        }


    }

    //Filter
    public void filter(int subOption, CreditCardAnalysis[] customer) {
        if (subOption == 1) {
            System.out.println("Enter the limit");
            long filterAmount = new Scanner(System.in).nextLong();
            for (CreditCardAnalysis each : customer) {
                if (each.getCreditCardLimit() < +filterAmount) {
                    System.out.println(each.getCreditCardHolder() + "\tyour credit card\t" + each.getCreditCardLimit());

                }
            }

        } else {
            System.out.println("Enter Data");
            int date = new Scanner(System.in).nextInt();
            for (CreditCardAnalysis each : customer)
                if (each.getDateOfBillPayment().getDate() <= date) {
                    System.out.println(each.getCreditCardHolder() + "\tyour credit card bill payment date\t" + each.getDateOfBillPayment());

                }
        }
    }

    //update
    public void update(int subOption, CreditCardAnalysis[] customer) {
        if (subOption == 1) {
            System.out.println("Enter card number");
            long cardNumber = new Scanner(System.in).nextInt();
            System.out.println("Enter the old PIN");
            int pin = new Scanner(System.in).nextInt();
            for (CreditCardAnalysis each : customer) {
                if (each.getCreditCardNumber() == cardNumber) {
                    if (each.getCreditCardPin() == pin) {
                        System.out.println("Enter the new PIN");
                        int updatePin = new Scanner(System.in).nextInt();
                        each.setCreditCardPin(updatePin);
                        System.out.println("Pin update successful");
                    }
                }
            }
        } else {
            for (CreditCardAnalysis each : customer) {
                if (each.getDateOfBillGeneration().getDate() == 5) {
                    each.setCreditCardLimit((int) (each.getCreditCardLimit() + (each.getCreditCardLimit() * 0.5)));
                    // each.setCreditCardLimit((int)(each.getCreditCardLimit()+each.getCreditCardLimit()+"your credit card limit as been increased to"+each.getCreditCardLimit());
                    System.out.println("Congratulations" + each.getCreditCardHolder() + "your credit card limit as been increased to" + each.getCreditCardLimit());
                }
            }

        }

    }
}



