package skypro.com.springhomework.Service.Impl;

import skypro.com.springhomework.Data.Employee;
import skypro.com.springhomework.Exception.EmployeeNotFoundException;
import skypro.com.springhomework.Service.DepartmentService;
import skypro.com.springhomework.Service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.inDepartment(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.inDepartment(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @Override
    public Collection<Employee> getEmployeesFor(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.inDepartment(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
