package SetsandMapsExercises;

import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> contacts = new HashMap<>();

        while (!input.equalsIgnoreCase("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            if (contacts.containsKey(name)) {
                contacts.put(contacts.get(name), number);
            }
            contacts.putIfAbsent(name, number);
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("stop")) {
            if (contacts.containsKey(command)) {
                System.out.println(command + " -> " + contacts.get(command));
            } else {
                System.out.printf("Contact %s does not exist.%n", command);
            }
            command = scanner.nextLine();
        }
    }
}

