package SetsandMapsExercises;

import javax.imageio.event.IIOReadProgressListener;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int sizeOfFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int sizeOfSecondSet = Integer.parseInt(input.split("\\s+")[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();


        for (int number = 1; number <= sizeOfFirstSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            firstSet.add(value);
        }
        for (int number = 1; number <= sizeOfSecondSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            secondSet.add(value);
        }

        //отпечатваме общите елементи за двата сета
        //1 начин
       // Set<Integer> duplicateElements = new LinkedHashSet<>();
       // for (int number:firstSet) {
         //   if (secondSet.contains(number)){
        //или да се отпечата директно на конзолата без да се съхранява в нов сет
           //     duplicateElements.add(number);
            //}
        //}
        //duplicateElements.forEach(System.out::println);
        firstSet.retainAll(secondSet);
        //тази функционалност премагва всички елементи от първият сет
        // , който ги няма във вторият

        firstSet.forEach(el -> System.out.print(el + " "));
    }
}
