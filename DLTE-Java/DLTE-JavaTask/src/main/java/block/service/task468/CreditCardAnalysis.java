//package block.service.task468;
//
//import java.util.Date;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import static java.lang.System.exit;
//
//public class CreditCardAnalysis {
//    public static void main(String[]args){
//
//        CreditCard[] mybank={
//                new CreditCard(8965935425,"Shreya",new Date(2044,04,25),200,14525,new Date(2041,06,25),8965),
//                new CreditCard(7865935425,"Sri",new Date(2044,09,24),270,825,new Date(2041,02,14),9665),
//        };
//        int option;
//        Scanner scanner=new Scanner(System.in);
//        //menu
//        While(true){
//            System.out.println("enter your choice\n1.Filter based on limits\n2.Filter based on date\n3.Update pin\n4.update limit whose bill payment date on 25");
//            option=scanner.nextInt();
//            CreditCardAnalysis analysis=new CreditCardAnalysis();
//            Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//            switch (option){
//                case 1:
//                    try{
//                        analysis.FilterOnLimits(myBank);
//                        break;
//
//                    }
//                    catch (MyBankCreditCardException cardLimit){
//                        logger.log(Level.WARNING,cardLimit.toString());
//                        anaylsis.FilterOnLimits(mybank);
//                        break;
//                    }
//                case 2:
//                    try {
//                        analysis.FilterOnDate(myBank);
//                        break;
//                    }
//                    catch (MyBankCreditCardException cardLimit){
//                        logger.log(Level.WARNING, cardLimit.toString());
//                        analysis.FilterOnDate(myBank);
//                        break;
//                    }
//                case 3:
//                    analysis.PinNumberUpdate(myBank);
//                    break;
//                case 4:
//                    analysis.UpdateLimit(myBank);
//                    break;
//                case 5:
//                    exit(0);
//
//                }
//            }
//
//        }
//    public void FilterOnLimits(CreditCard[] customers) {
//        Long StartLimit,EndLimit;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the start range to filter");
//        StartLimit = scanner.nextLong();
//        System.out.println("Enter the end limit");
//        EndLimit = scanner.nextLong();
//        boolean flag=true;
//        for(CreditCard each: customers){
//            if(each.getCreditCardLimit()>=StartLimit &&each.getCreditCardLimit()<=EndLimit){
//                flag=false;
//                System.out.println(each.getCreditCardHolder()+" Has a limit of "+each.getCreditCardLimit());
//            }
//        }
//        if(flag){
//            throw new MyBankCreditCardException();
//        }
//
//
//    }
//    //to filter the customer based on the date of bill payment
//    public void FilterOnDate(CreditCard[] customers){
//        String dateInput;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter date of bill payment in dd/mm/yyyy format");
//        dateInput=scanner.next();
//        String splitDate[]=dateInput.split("/");
//        boolean flag=true;
//        for(CreditCard each: customers){
//            if((Integer.parseInt(splitDate[0])==(each.getDateOfBillGenearation()).getDate())&&(Integer.parseInt(splitDate[1])==(each.getDateOfBillGenearation()).getMonth())&&(Integer.parseInt(splitDate[2])==(each.getDateOfBillGenearation()).getYear())){
//                System.out.println("The account holder "+each.getCreditCardHolder()+" has date of bill on "+dateInput);
//                flag=false;
//            }
//        }
//        if(flag){
//            throw new MyBankCreditCardException();
//        }
//
//
//    }
//    //to change the pin number of a card for a particular user
//    public void PinNumberUpdate(CreditCard[] customers)
//    {
//        int CurrentPin,NewPin;
//        Long CreditCardNumber=0L;
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Please enter your card number for changing password");
//        CreditCardNumber=scanner.nextLong();
//        for(CreditCard each :customers){
//            if(each.getCreditCardNumber().equals(CreditCardNumber)){
//                System.out.println("Enter your current pin");
//                CurrentPin=scanner.nextInt();
//                if(CurrentPin==each.getCreditCardPin()){
//                    System.out.println("Enter your new pin");
//                    NewPin=scanner.nextInt();
//                    each.setCreditCardPin(NewPin);
//                    System.out.println("New pin is set");
//                }
//                else{
//                    System.out.println("Wrong pin");
//                }
//            }
//
//        }
//    }
//
//    //50% increase in limit for those customer with bill genaration date 5
//    public void UpdateLimit(CreditCard[] customer){
//        double NewCreditCardLimit;
//        int roundOffNewCreditLimit;
//        for(CreditCard each:customer){
//            if((each.getDateOfBillGenearation()).getDate()==5){
//                NewCreditCardLimit= (each.getCreditCardLimit() * 0.05) + each.getCreditCardLimit();
//                roundOffNewCreditLimit= (int) Math.round(NewCreditCardLimit);
//                each.setCreditCardLimit(roundOffNewCreditLimit);
//                System.out.println("Successfully updated");
//            }
//        }
//    }
//
//}

