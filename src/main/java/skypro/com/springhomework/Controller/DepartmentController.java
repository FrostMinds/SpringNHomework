package skypro.com.springhomework.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.com.springhomework.Service.DepartmentService;
import skypro.com.springhomework.Data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    Employee getEmployeeWithMinSalary(@RequestParam(name = "department") int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }

    @GetMapping("/maxSalary")
    Employee getEmployeeWithMaxSalary(@RequestParam(name = "department") int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping(value = "/all", params = {"detartment"})
    Collection<Employee> getEmployeeFor(@RequestParam(name = "department") int department) {
        return departmentService.getEmployeesFor(department);
    }

    @GetMapping("/all")
    Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployeesByDepartment();
    }
}
