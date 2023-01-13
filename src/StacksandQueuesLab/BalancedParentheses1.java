package StacksAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openBraketStack = new ArrayDeque<>();

        boolean areBalanced = false;

        for (char bracket : input.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {

                openBraketStack.push(bracket);

            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (openBraketStack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = openBraketStack.pop();
                if (lastOpenBracket == '(' && bracket == ')') {
                    areBalanced = true;

                } else if (lastOpenBracket == '[' && bracket == ']') {
                    areBalanced = true;

                } else if (lastOpenBracket == '{' && bracket == '}') {
                    areBalanced = true;

                } else {
                    areBalanced = false;
                    break;
                }

            }

        }
            if (areBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

    }
}
