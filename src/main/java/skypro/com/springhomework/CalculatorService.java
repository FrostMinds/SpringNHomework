package skypro.com.springhomework;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int division(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Non zero value for num2 is required");
        }
        return num1 / num2;
    }
}
