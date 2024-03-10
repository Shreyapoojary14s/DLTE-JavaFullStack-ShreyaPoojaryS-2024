package block.service.task469;

import java.util.ResourceBundle;

    public class MyBankException extends RuntimeException{
        public MyBankException(String s){
            super(ResourceBundle.getBundle("application").getString("pin.invalid"));
        }

}
