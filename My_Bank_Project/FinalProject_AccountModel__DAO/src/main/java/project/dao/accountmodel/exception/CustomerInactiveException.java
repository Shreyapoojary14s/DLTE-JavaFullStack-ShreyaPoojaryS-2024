package project.dao.accountmodel.exception;

public class CustomerInactiveException extends  RuntimeException {
    public CustomerInactiveException (String message){
        super(message);
    }
}
