package FunctionalprigrammingExercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Function< приема , връща > -> apply
        //Consumer<приема> -> void -> accept
        //Supplier <връща> get
        //Predicate<приема> -> връща true/false ->test
        //BiFunction<приема1,приема2,връща> -> apply

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        //System.out.println(Collections.min(numbers));
        //1 начин без Functional Programming

        //2 начин
        //подаваме листа и си отпечатваме минималното число което е в листа

        //Consumer<List<Integer>> printMinNumber = List -> System.out.println(Collections.min(List));
       //  printMinNumber.accept(numbers);


         // 3 начин
        Function<List<Integer>,Integer> getMInNumber = list -> Collections.min(list);
        //getMinNumber приема List и връща стойност от цяло число,която е минималната стойност.
        System.out.println(getMInNumber.apply(numbers));
        //или да го изнесем в променлива,която да отпечатаме след това
        int minElement = getMInNumber.apply(numbers);
        System.out.println(minElement);

    }
}
