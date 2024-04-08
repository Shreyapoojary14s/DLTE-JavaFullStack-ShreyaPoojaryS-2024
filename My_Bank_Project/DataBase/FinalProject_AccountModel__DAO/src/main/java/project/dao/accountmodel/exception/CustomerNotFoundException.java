package project.dao.accountmodel.exception;

public class CustomerNotFoundException extends RuntimeException {
    //customer not found exception
    public CustomerNotFoundException (String message){
        super(message);
    }

}
