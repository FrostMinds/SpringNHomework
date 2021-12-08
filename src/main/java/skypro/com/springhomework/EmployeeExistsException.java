package skypro.com.springhomework;

public class EmployeeExistsException extends RuntimeException{

    public EmployeeExistsException() {
        super("Employee already add to that list");
    }
}
