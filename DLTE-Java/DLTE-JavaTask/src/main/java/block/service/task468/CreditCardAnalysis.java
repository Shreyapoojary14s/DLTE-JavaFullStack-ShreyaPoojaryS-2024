package block.service.task468;

import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class CreditCardAnalysis {
    public static void main(String[]args) throws MyBankCreditCardException {

        CreditCard[] myBank={

                new CreditCard(8965935425L,"Shreya",new Date(2044,04,25),200,1400,new Date(2041,06,25),new Date(2023/03/04),8965),
                new CreditCard(7865935425L,"Siri",new Date(2044,03,24),270,825,new Date(2041,02,14),new Date(2023/04/01),9665),
        };
        int option;
        Scanner scanner=new Scanner(System.in);
        //menu

            System.out.println("enter your choice\n1.Filter based on limits\n2.Filter based on date\n3.Exit");
            option=scanner.nextInt();
            CreditCardAnalysis analysis=new CreditCardAnalysis();
            Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            switch (option){
                case 1:
                    try{
                        analysis.FilterOnLimits(myBank);
                        break;

                    }
                    catch (Exception e){
                        logger.log(Level.WARNING,e.toString());
                        analysis.FilterOnLimits(myBank);
                        break;
                    }
                case 2:
                    analysis.FilterOnDate(myBank);
                    break;

                case 3:
                    exit(0);

                }
            }


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
            if((Integer.parseInt(splitDate[0])==(each.getDate()).getDate())&&(Integer.parseInt(splitDate[1])==(each.getDate()).getMonth())&&(Integer.parseInt(splitDate[2])==(each.getDate()).getYear())){
                System.out.println("The account holder "+each.getCardHolder()+" has date of bill on "+dateInput);
                flag=false;
            }
        }
        if(flag){
            throw new MyBankCreditCardException();
        }


    }

}

