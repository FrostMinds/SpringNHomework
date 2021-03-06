package skypro.com.springhomework.Service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import skypro.com.springhomework.Data.Employee;
import skypro.com.springhomework.Exception.EmployeeExistsException;
import skypro.com.springhomework.Exception.EmployeeNotFoundException;
import skypro.com.springhomework.Service.EmployeeService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



@Service
public class EmployeeServiceImpl implements EmployeeService {

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
        Employee newEmployee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(secondName));
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(secondName)) {
            throw new IllegalArgumentException();
        }
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
    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return null;
    }
}