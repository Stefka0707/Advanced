package SetsandMapsExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        //име на човек срещъ него имеил

        Map<String,String >emailsData= new LinkedHashMap<>();
        //linkedHashMap = за да се запази реда на добавяне

        while (!name.equals("stop")){
            //име на човек
            String email= scanner.nextLine();
            if (!email.contains("uk") && !email.endsWith ("us") && !email.endsWith ("com"))
            emailsData.put(name,email);

            name=scanner.nextLine();
        }
        //отпечатваме име -> имеил
        //премахване на всички записи които велюто им завършва на ук,ус,ком
        // removeIf - премахва всички записи, които отговарят на условието ;)
        emailsData.entrySet().removeIf(entry-> entry.getValue().endsWith("uk")||entry.getValue().endsWith("us")||entry.getValue().endsWith("com"));
        emailsData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
