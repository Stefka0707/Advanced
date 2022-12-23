package StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimaltoBinaryConverter03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> sack = new ArrayDeque<>();

        if (number==0){
            System.out.println(0);
        }

        while (number != 0) {
            sack.push(number % 2);
            number /= 2;
        }
        for (Integer integer : sack) {
            System.out.print(integer);

        }

    }
}
