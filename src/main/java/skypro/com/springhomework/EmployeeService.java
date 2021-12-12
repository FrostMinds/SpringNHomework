package skypro.com.springhomework;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService{

    private final Set<Employee> employees;

    public EmployeeService() {
        employees = new HashSet<>();
    }

    public Employee add(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        return add(newEmployee);
    }

    public Employee add(Employee employee) {
        if (!employees.add(employee)) {

            throw new EmployeeExistsException();
        }
        return employee;
    }

        public Employee remove(String firstName, String secondName){
            Employee newEmployee = new Employee(firstName, secondName);
            return remove(newEmployee);
        }

        public Employee remove (Employee employee){
            if (!employees.remove(employee)) {
                throw new EmployeeNotFoundException();
            }

            return employee;
        }

        public Employee find (String firstName, String secondName){
            Employee employee = new Employee(firstName, secondName);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
                return employee;
        }


    public Collection<Employee> getAll() {
        return Set.copyOf(employees);
    }
}