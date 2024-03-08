package block.service.task468;

import java.util.ResourceBundle;
import static java.util.ResourceBundle.*;

public class MyBankCreditCardException extends Throwable {
//
public MyBankCreditCardException() {
    //if the exception occurs message from application.properties is imported and displayed
    super(ResourceBundle.getBundle("application").getString("exception.creditcard"));
}



}

