package StacksandQueuesLab;


import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String currentURL = null;

        ArrayDeque<String> urlSQueue = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (urlSQueue.isEmpty()) {
                    System.out.println("no previous URLs");
                    command=scanner.nextLine();
                    continue;
                } else {
                    currentURL = urlSQueue.pop();
                }

            } else {
                if (currentURL != null) {
                    urlSQueue.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = scanner.nextLine();

            }
        }

}
