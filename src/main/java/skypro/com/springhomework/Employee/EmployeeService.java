package skypro.com.springhomework.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String secondName);

    Employee add(Employee employee);

    Employee remove(String firstName, String secondName);

    Employee remove(Employee employee);

    Employee find(String firstName, String secondName);

    Collection<Employee> getAll();
}
