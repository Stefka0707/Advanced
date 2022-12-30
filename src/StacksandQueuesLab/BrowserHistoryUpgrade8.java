package StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String currentURL = null;
        String previous =null;
        ArrayDeque<String> urlSQueue = new ArrayDeque<>();

        while (!command.equals("Home")) {

            switch (command){
                case "forward":
                    if (urlSQueue.isEmpty()){
                        System.out.println("no next URLs");
                    }else {
                        previous = urlSQueue.peek();
                        System.out.println(urlSQueue.pollFirst());
                    }
                    break;
                case "back":
                    if (urlSQueue.isEmpty()){
                        System.out.println("no previous URLs");
                    }else {
                        System.out.println(previous);
                    }
                    break;
                default:
                    currentURL = command;
                    System.out.println(currentURL);

                    if (!urlSQueue.isEmpty()) {
                        previous = urlSQueue.poll();
                    }
                    urlSQueue.offer(currentURL);
            }
            command=scanner.nextLine();
        }

    }
}