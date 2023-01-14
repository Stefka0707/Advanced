package StacksAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

public class ReverseNumberswithaStack01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>number = new ArrayDeque<>();
        stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(e -> number.push(e));
        while (!number.isEmpty()){
            int num = number.pop();
            System.out.print(num +" ");
        }
    }
}
