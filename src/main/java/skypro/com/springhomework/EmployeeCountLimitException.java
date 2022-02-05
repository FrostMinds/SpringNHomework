package skypro.com.springhomework;

public class EmployeeCountLimitException extends RuntimeException {

    public EmployeeCountLimitException() {
        super("List is full");
    }
}
