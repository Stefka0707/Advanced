package StacksAndQueueExercises;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        ArrayDeque<String> textStack = new ArrayDeque<>();
        StringBuilder textBuilder = new StringBuilder();

        if (n >= 1 && n <= 105) {
            for (int i = 0; i < n; i++) {

                String command = scanner.nextLine();
                String nameCommand = command.split("\\s+")[0];

                switch (nameCommand) {
                    case "1":
                        String name = command.split("\\s+")[1];
                        textStack.push(textBuilder.toString());
                        textBuilder.append(name);
                        break;
                    case "2":
                        int count = Integer.parseInt(command.split("\\s+")[1]);
                        textStack.push(textBuilder.toString());
                        textBuilder = new StringBuilder(textBuilder.delete(textBuilder.length() - count, textBuilder.length()));
                        break;
                    case "3":
                        int index = Integer.parseInt(command.split("\\s+")[1]);
                        System.out.println(textBuilder.charAt(index - 1));

                        break;
                    case "4":
                        textBuilder = new StringBuilder(textStack.pop());
                        break;
                }


            }
        }
    }
}
