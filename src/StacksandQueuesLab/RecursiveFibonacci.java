package StacksAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> fibonacci = new ArrayDeque<>();

        fibonacci.push(0l);
        fibonacci.push(1l);
        if (n < 2) {
            System.out.println("1");
        }
        for (int i = 0; i < n; i++) {
            long number1 = fibonacci.pop();
            long number2 = fibonacci.pop();
           fibonacci.push(number1);
           fibonacci.push(number1 + number2);
        }
        System.out.println(fibonacci.pop());
    }
}
