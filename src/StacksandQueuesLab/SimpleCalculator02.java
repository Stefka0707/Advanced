package StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i <input.length ; i++) {
            String token=input[i];
            if (Character.isDigit(token.charAt(0))){
                numbers.push(Integer.parseInt(token));

            }else {
                int rightOperand = Integer.parseInt(input[++i] );
               int leftOperand = numbers.peek();
                numbers.push(rightOperand);
                int result = token.equals("+")
                        ? leftOperand + rightOperand
                        : leftOperand- rightOperand;

                numbers.push(result);
            }
        }
        System.out.println(numbers.peek());
        }
    }

