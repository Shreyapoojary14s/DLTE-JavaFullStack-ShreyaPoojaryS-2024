package block.service.task469;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Execute {
        public static void main(String[] args){
            ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
            Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            Gpay gpay=new Gpay(987654323456L,678765.00,"Anvith","8585");
            Scanner scanner=new Scanner(System.in);
            int count=0;
            while (count<5){
                System.out.println("Enter name");
                String billerName=scanner.next();
                System.out.println("Enter amount");
                Double billAmount = scanner.nextDouble();
                System.out.println("Enter Type");
                String billType=scanner.next();
                try{
                    System.out.println("Enter Number");
                    String Pin=scanner.next();
                    gpay.payBill(billerName,billAmount,billType,Pin);
                    count=0;
                    return;
                }catch (MyBankException exception){
                    logger.log(Level.WARNING,exception.toString());
                    count++;

                    //give 5 chance
                    if (count>=4){
                        logger.log(Level.WARNING,"Account blocked.contact your bank");   //warnings
                        break;
                    }
                }
            }
            scanner.close();
        }

}
