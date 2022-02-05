package skypro.com.springhomework;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException() {
        super("Can't found employee");
    }
}
