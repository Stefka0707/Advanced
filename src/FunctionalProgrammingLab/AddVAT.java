package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> vatCalculator = val -> val * 1.2;

     System.out.println("Prices with VAT:");
        String values = Arrays.stream(scanner.nextLine().split(", "))
                .map(e-> String.format("%.2f",vatCalculator.apply(Double.parseDouble(e))))
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(values);


    }
}
