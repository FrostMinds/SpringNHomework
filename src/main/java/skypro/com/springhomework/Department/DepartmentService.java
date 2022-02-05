package skypro.com.springhomework.Department;

import skypro.com.springhomework.Employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee getEmployeeWithMinSalary(int department);

    Employee getEmployeeWithMaxSalary(int department);

    Collection<Employee> getEmployeesFor(int department);
    Map<Integer, List<Employee>> getAllEmployeesByDepartment();
}
