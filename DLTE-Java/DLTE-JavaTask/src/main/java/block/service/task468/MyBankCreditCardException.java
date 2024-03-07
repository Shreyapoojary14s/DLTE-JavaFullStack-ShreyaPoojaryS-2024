package block.service.task468;

import java.util.ResourceBundle;
import static java.util.ResourceBundle.*;

public class MyBankCreditCardException extends Throwable {
    public MyBankCreditCardException(){
        super(getBundle("creditcard").getString("exception.creditcard"));

    }

}

