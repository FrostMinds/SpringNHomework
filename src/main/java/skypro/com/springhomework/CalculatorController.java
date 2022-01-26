package skypro.com.springhomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String greetings() {
        return "Добро пожаловать в калькулятор.";
    }

    @GetMapping("/plus")
    public String sumNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.sum(num1, num2);
        return genMessage(num1, num2, "+", result);
    }

    @GetMapping("/minus")
    public String minusNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.minus(num1, num2);
        return genMessage(num1, num2, "-", result);
    }

    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiply(num1, num2);
        return genMessage(num1, num2, "*", result);
    }

    @GetMapping("/division")
    public String divisionNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.division(num1, num2);

        return genMessage(num1, num2, "/", result);
    }

    private String genMessage(int num1, int num2, String mathSign, int result) {
        return String.format("<h1>%d %c %d = %d</h1>", num1, mathSign, num2, result);

    }
}
