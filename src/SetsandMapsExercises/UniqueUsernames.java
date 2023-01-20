package SetsandMapsExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> words = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int countWords = 1; countWords <= n; countWords++) {
            String word = scanner.nextLine();
            words.add(word);//това го добава само ако го няма автоматично си прави проверка
        }
        words.forEach(System.out::println);
    }

}
