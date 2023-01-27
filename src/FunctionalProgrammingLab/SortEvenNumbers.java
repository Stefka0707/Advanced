package FunctionalProgrammingLab;

import com.company.Main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] numbers  = Arrays.stream(scanner.nextLine()
                        .split(", ")).mapToInt(Integer::parseInt)
                .filter(mathematcmethods::isEven)
                .toArray();
        System.out.println(formatArray(numbers));
        Arrays.sort(numbers);
        System.out.println(formatArray(numbers));
    }
public static   String formatArray (int []arr){
// за да ги превърнем с стрингове използваме Мар
    return Arrays.stream(arr).mapToObj(String:: valueOf).collect(Collectors.joining(", "));
}
}
