package skypro.com.springhomework.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String secondName,
                      @RequestParam int department, @RequestParam int salary) {
        Employee result = employeeServiceImpl.add(firstName, secondName, department, salary);
        return generateMessage(result, "добавлен в список");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String secondName) {
        Employee result = employeeServiceImpl.remove(firstName, secondName);
        return generateMessage(result, "удалён из списка");
    }

    @GetMapping
    public Employee find(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeServiceImpl.find(firstName, secondName);
    }

    @GetMapping("/all")
    public Collection<Employee> all() {
        return employeeServiceImpl.getAll();
    }

    private String generateMessage(Employee employee, String status) {
        return String.format("Сотрудник %s %s %s.", employee.getFirstName(), employee.getSecondName(), status);
    }
}
