package StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> queue.offer(e));

        int n = Integer.parseInt(scanner.nextLine());
        while (queue.size() > 1){
            for (int i = 1; i <n ; i++) {
                queue.offer(queue.poll());

            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());

    }
}
