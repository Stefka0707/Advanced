package FunctionalprigrammingExercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Function< приема , връща > -> apply
        //Consumer<приема> -> void -> accept
        //Supplier <връща> get
        //Predicate<приема> -> връща true/false ->test
        //BiFunction<приема1,приема2,връща> -> apply

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {
            // command = "add", ""multiply","subtract","print"
            //add = добавяме 1 към всеки елемент на листа приема лист -> връща модифициран лист
            Function<List<Integer>, List<Integer>> addCommand =
                    List -> List.stream().map(number -> number + 1).collect(Collectors.toList());
            //multiply = умножаваме всеки елемент по 2 приема списък -> връща списък с модифицирани елементи
            Function<List<Integer>, List<Integer>> multiplyCommand =
                    List -> List.stream().map(number -> number * 2).collect(Collectors.toList());

            //subtract = изважда 1 от всеки елемент на списъка : приема списък -> връща списък с модифицирани елементи
            Function<List<Integer>, List<Integer>> subtractCommand =
                    List -> List.stream().map(number -> number - 1).collect(Collectors.toList());
            //print = принтира всички елементи на списъка на нов ред : приема списък -> отпрчатва всеки елемент

            Consumer<List<Integer>> printCommand = List -> List.forEach(number -> System.out.print(number + " "));

            switch (command) {
                case "add":
                    numbers = addCommand.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyCommand.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractCommand.apply(numbers);
                    break;
                case "print":
                    printCommand.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();

        }


    }
}
