package project.dao.accountmodel.exception;

public class AccountAlreadyExistException extends  RuntimeException {
    public AccountAlreadyExistException(String message){
        super(message);
    }
}
