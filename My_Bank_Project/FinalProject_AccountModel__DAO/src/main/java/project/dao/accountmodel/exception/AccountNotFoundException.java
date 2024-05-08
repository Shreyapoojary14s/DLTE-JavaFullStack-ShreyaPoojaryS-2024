package project.dao.accountmodel.exception;

public class AccountNotFoundException extends RuntimeException {
    //account not found exception
    public AccountNotFoundException(String message){
        super(message);
    }
}
