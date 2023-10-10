package az.company.taskofbank.exceptionCustomer;

public class CustomerException extends RuntimeException{
    public CustomerException(String message) {
        super(message);
    }
}
