package StacksAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        boolean isBalanced = true;
        ArrayDeque<String> brackets = new ArrayDeque<>();
        if (expression.length() % 2 != 0) {
            isBalanced = false;
        } else {
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '{' || expression.charAt(i) == '(' || expression.charAt(i) == '[') {
                    brackets.push(String.valueOf(expression.charAt(i)));
                } else {
                    if (String.valueOf(expression.charAt(i)).equals(")") && !brackets.pop().equals("(")) {
                        isBalanced = false;
                        break;
                    } else if (String.valueOf(expression.charAt(i)).equals("]") && !brackets.pop().equals("[")) {
                        isBalanced = false;
                        break;
                    } else if (String.valueOf(expression.charAt(i)).equals("}") && !brackets.pop().equals("{")) {
                        isBalanced = false;
                        break;
                    }
                }

            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}


