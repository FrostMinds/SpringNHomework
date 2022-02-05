package skypro.com.springhomework;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final Employee[] employees;
    private int size;

    public EmployeeService() {
        employees = new Employee[10];
    }

    public int indexOf(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                return i;
            }
        }
        return -1;
    }

    public Employee add(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        return add(newEmployee);
    }

    public Employee add(Employee employee) {
        if (size == employees.length) {
            throw new EmployeeCountLimitException();
        }
        int index = indexOf(employee);

        if (index != -1) {
            throw new EmployeeExistsException();
        }

        employees[size++] = employee;
        return employee;
    }

    public Employee remove(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        return remove(newEmployee);
    }

    public Employee remove(Employee employee) {
        int index = indexOf(employee);

        if (index != -1) {
            Employee result = employees[index];
            System.arraycopy(employee, index + 1, employees, index, size - index);
            size--;
            return result;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String secondName) {
        Employee newEmployee = new Employee(firstName, secondName);
        int index = indexOf(newEmployee);

        if (index != -1) {
            return employees[index];
        }

        throw new EmployeeNotFoundException();
    }
}
