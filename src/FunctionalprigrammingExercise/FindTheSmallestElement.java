package FunctionalprigrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Function< приема , връща > -> apply
        //Consumer<приема> -> void -> accept
        //Supplier <връща> get
        //Predicate<приема> -> връща true/false ->test
        //BiFunction<приема1,приема2,връща> -> apply

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        //лист -> отпечатва последния индекс на най-малкото число

        //1 начин
        // LastIndexOf -> връща последния индекс, на които срещаме дадения елеменд
        // IndexOf -> връща първия индекса при първото срещане на дадения елемент.
        Consumer<List<Integer>> printLastIndexOfMinElement = List ->{
            int minElement = Collections.min(List);
            System.out.println(List.lastIndexOf(minElement));
        };
        printLastIndexOfMinElement.accept(numbers);

        // 2 начин
        // List -> връща последния индекс, на които срещаме минималния елемент

       // Function<List<Integer>,Integer> getLastIndexOfMinElement = List ->List.lastIndexOf(Collections.min(List));
        //System.out.println(getLastIndexOfMinElement.apply(numbers));
    }
}
