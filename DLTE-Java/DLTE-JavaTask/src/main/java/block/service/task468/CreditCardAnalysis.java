package block.service.task468;

import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.System.exit;

public class CreditCardAnalysis {

    public static void main(String[] args) throws NullPointerException, MyBankCreditCardException {
           //hardcode data
            CreditCard[] myBank = {
                    new CreditCard(7485122212L, "Shreya", new Date(2034, 12, 13), 123, 10000, new Date(2031, 05, 06), new Date(2032, 06, 20), 4567),
                    new CreditCard(5285855412L, "Harshitha", new Date(2029, 10, 20), 153, 30000, new Date(2032, 07, 21), new Date(2038, 06, 5), 4580),
                    new CreditCard(6985509682L, "Arpitha", new Date(2030, 9, 15), 163, 25000, new Date(2039, 12, 5), new Date(2031, 06, 20), 4500),
            };
            int choice;
            Scanner scanner = new Scanner(System.in);
            //menu
            while (true) {
              //  Logger logger=Logger.getLogger(Logger.GLOBL_LOGGER_NAME);
                System.out.println("1)Filter based on limits\n" + "2)Filter based on date\n" + "3) to exit");
                CreditCardAnalysis analysis = new CreditCardAnalysis();
                Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        analysis.FilterOnLimits(myBank);//filter on limit
                        break;
                    case 2:
                        try{
                            analysis.FilterOnDate(myBank);//filter on range of date
                            break;
                        }
                        catch (MyBankCreditCardException cardLimit){
                            logger.log(Level.WARNING,cardLimit.toString());
                           // logger.log(Level.INFO,cardLimit.toString());
                            analysis.FilterOnDate(myBank);
                            break;

                        }

                    case 3:
                        exit(0);

                }
            }
        }

        //Filter
        public void FilterOnLimits(CreditCard[] customers) throws MyBankCreditCardException {
            Long StartLimit,EndLimit;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the start range to filter");
            StartLimit = scanner.nextLong();
            System.out.println("Enter the end limit");
            EndLimit = scanner.nextLong();
            boolean flag=true;
            for(CreditCard each: customers){
                if(each.getCardLimit()>=StartLimit &&each.getCardLimit()<=EndLimit){
                    flag=false;
                    System.out.println(each.getCardHolder()+" Has a limit of "+each.getCardLimit());
                }
            }
            if(flag){
                throw new MyBankCreditCardException();
            }


        }




    public void FilterOnDate(CreditCard[] customers) throws MyBankCreditCardException {
        String dateInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date of bill payment in dd/mm/yyyy format");
        dateInput=scanner.next();
        String splitDate[]=dateInput.split("/");
        boolean flag=true;
        for(CreditCard each: customers){
            if((Integer.parseInt(splitDate[0])==(each.getDateOfBillGenearation()).getDate())&&(Integer.parseInt(splitDate[1])==(each.getDateOfBillGenearation()).getMonth())&&(Integer.parseInt(splitDate[2])==(each.getDateOfBillGenearation()).getYear())){
                System.out.println("The account holder "+each.getCardHolder()+" has date of bill on "+dateInput);
                flag=false;
            }
        }
        if(flag){
            throw new MyBankCreditCardException();
        }


    }



}


