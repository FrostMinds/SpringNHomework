package skypro.com.springhomework.Service;

import skypro.com.springhomework.Data.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String secondName, int department1, int salary1);

    Employee add(Employee employee);

    Employee remove(String firstName, String secondName);

    Employee remove(Employee employee);

    Employee find(String firstName, String secondName);

    Collection<Employee> getAll();
}
