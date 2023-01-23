package SetsandMapsExercises;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            elements.addAll(List.of(tokens));

        }
        for (String element : elements) {

            System.out.printf("%s ", element);
        }
    }
}
