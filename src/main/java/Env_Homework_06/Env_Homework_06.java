package Env_Homework_06;

import java.util.*;

public class Env_Homework_06 {

    private static final List<Integer> nums = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5, 6, 7);
    private static final List<String> words = Arrays.asList("Иван", "Василий", "Дмитрий", "Катерина", "Василий");

    public static void main(String[] args) {


        for (Integer num : nums) {
            if (num % 2 != 0) {
                System.out.println(num + " ");
            }
        }
        System.out.println();


        List<Integer> uniqueList = new ArrayList<>(Set.copyOf(nums));
        Collections.sort(uniqueList);
        uniqueList.removeIf(num -> num % 2 != 0);
        for (Integer num : uniqueList) {
            System.out.println(num + " ");
        }
        System.out.println();


        Set<String> uniqueWord = new LinkedHashSet<>(words);
        System.out.println(uniqueWord);


        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println(words.size() - uniqueWords.size());
    }
}
