package StacksAndQueueExercises;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] symbol = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = symbol[0];
        int numToPoll = symbol[1];
        int numToCheck = symbol[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 1; i <= numToPoll; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(numToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}
