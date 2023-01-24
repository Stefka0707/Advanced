package SetsandMapsExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> word = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (!word.containsKey(input.charAt(i))){
                word.put(input.charAt(i),1);
            }else {
                word.put(input.charAt(i),word.get(input.charAt(i))+1);
            }

        }
        for (Map.Entry<Character,Integer> entry:word.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
