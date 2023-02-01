package FunctionalprigrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String []names = input.split("\\s+");

        Consumer<String> printName = name -> System.out.printf("Sir %s%n",name);
//        for (String name :names){
//            printName.accept(name);
//        }
    //втори начин :)
        Arrays.stream(names).forEach(printName);
    }
}
