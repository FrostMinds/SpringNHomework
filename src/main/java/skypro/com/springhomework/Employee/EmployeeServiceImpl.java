package skypro.com.springhomework.Employee;

import org.springframework.stereotype.Service;

import java.util.*;



@Service
public abstract class EmployeeServiceImpl implements EmployeeService {

    private final Set<Employee> employees;

    private String getKey(Employee employee) {
        return getKey(employee.getFirstName(), employee.getSecondName());
    }

    private String getKey(String firstName, String secondName) {
        return firstName + "_" + secondName;
    }

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }


    public Employee add(String firstName, String secondName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, secondName);
        return add(newEmployee);
    }


    @Override
    public Employee add(Employee employee) {
        boolean employeeExistsException = !employees.add(employee);
        if (employeeExistsException) {
            throw new EmployeeExistsException();
        }
        return employee;
    }

    public Employee remove(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        return remove(newEmployee);
    }
    public Employee remove (Employee employee) {
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }
    public Employee find (String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
}