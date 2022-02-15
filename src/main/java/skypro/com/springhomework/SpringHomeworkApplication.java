package skypro.com.springhomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHomeworkApplication {
    public static IntegerList generateRandomArray() {
        java.util.Random random = new java.util.Random();
        IntegerList arr = new IntegerListImpl();
        for (int i = 0; i < 1000; i++) {
            arr.add(random.nextInt(1000));
        }
        return arr;
    }

    public static void main(String[] args) {

        IntegerList integerList = generateRandomArray();
        long start = System.currentTimeMillis();
        integerList.sortInsertion();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(integerList);
    }

}
