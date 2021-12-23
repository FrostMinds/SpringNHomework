package skypro.com.springhomework.Employee;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException() {
        super("Can't found employee");
    }
}
