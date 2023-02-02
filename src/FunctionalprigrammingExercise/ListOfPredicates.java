package FunctionalprigrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        // да отпечатаме всички числа от 1 до n
        // и отпечатваме числото, ако се дели на всички числа в списъка
        // приемам : число, списък за проверка
        // връща резултат true или false
        //true -> ако числото се дели на всички без остатък
        // false -> ако числото не се дели на всички числа
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, List) -> {
            for (int numInList : List) {
                if (number % numInList != 0) {
                    return false;
                }
            }
            return true;

        });
        for (int number = 1; number <= n; number++) {
            if (isDivisible.apply(number, numbers)) {
                System.out.print(number + " ");
            }
        }
    }
}
