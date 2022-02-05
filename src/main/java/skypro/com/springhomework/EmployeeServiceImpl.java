package skypro.com.springhomework;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private String getKey(Employee employee) {
        return getKey(employee.getFirstName(), employee.getSecondName());
    }

    private String getKey(String firstName, String secondName) {
        return firstName + "_" + secondName;
    }

    private final Map<String ,Employee> employees;

    public EmployeeServiceImpl() {
        employees = new LinkedHashMap<>();
    }

    public Employee add(String firstName, String secondName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, secondName);
        return add(newEmployee);
    }

    @Override
    public Employee add(String firstName, String secondName) {
        return null;
    }

    public Employee add(Employee employee) {
        String key = getKey(employee);

        if (employees.containsKey(key)) {
            throw new EmployeeExistsException();
        }

        employees.put(key, employee);
        return employee;
    }

        public Employee remove(String firstName, String secondName){
            Employee newEmployee = new Employee(firstName, secondName);
            return remove(newEmployee);
        }

        public Employee remove (Employee employee){
            Employee deletedValue = employees.remove(getKey(employee));
            if (deletedValue == null) {
                throw new EmployeeNotFoundException();
            }

            return employee;
        }

        public Employee find (String firstName, String secondName){
            String key = getKey(firstName, secondName);
            Employee employee = employees.get(key);
            if (employee == null) {
                throw new EmployeeNotFoundException();
            }
                return employee;
        }


    public Collection<Employee> getAll() {
        return Set.copyOf(employees.values());
    }
}