package skypro.com.springhomework.Exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException() {
        super("Can't found employee");
    }
}
