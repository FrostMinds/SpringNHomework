package skypro.com.springhomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    int a = 1;

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String secondName) {
        Employee result = employeeService.add(firstName, secondName);
        return generateMessage(result, "добавлен в список");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String secondName) {
        Employee result = employeeService.remove(firstName, secondName);
        return generateMessage(result, "удалён из списка");
    }

    @GetMapping
    public Employee find(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.find(firstName, secondName);
    }

    private String generateMessage(Employee employee, String status) {
        return String.format("Сотрудник %s %s %s.", employee.getFirstName(), employee.getSecondName(), status);
    }
}
