package skypro.com.springhomework.ExaminerService;

public class Random {

    int[] generateRandomArray; {
        java.util.Random random = new java.util.Random();
        arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;

    }
}
