package SetsandMapsExercises;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            //"{personName}: {PT, PT, PT,… PT}"
            String name = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];
            // 1 съхраняваме картите в сета
            Set<String> cardsSet = new HashSet<>();
            String[] cardsArray = cards.split(", ");
            cardsSet.addAll(Arrays.asList(cardsArray));
            // 2 добавяне на името в мапа
            // ако nе сме го записали
            if (!players.containsKey(name)) {
                players.put(name, cardsSet);

            } else {
                //ако сме го записали
                Set<String> currentCards = players.get(name);// дава ни стойността т.е картите който стоят срещу това име
                // и добавяме новите карти към старите, като сета не позволява да се повтарят
                currentCards.addAll(cardsSet);//към досегашните карти добавяме новите
                players.put(name, currentCards);//презаписваме съществуващото име с новите карти
            }

            input = scanner.nextLine();
        }

        //име -> списък с карти
        // какво ще направим за всяко едно име
        //итерираме по ключове и за всеки ключ при отпечатването сумираме точките

        players.entrySet().forEach(entry -> {
            int points = getCardsPOints(entry.getValue());
            System.out.printf("%s: %d%n", entry.getKey(), points);
        });
    }

    private static int getCardsPOints(Set<String> value) {
        //правим един мап за да съхраним всеки символ с каква  стойност е
        Map<Character, Integer> symbolsValue = getSymbolsValue();
        //Списък с карти - "2C", "4H", "9H", "AS", "QS"
            int sum = 0;
        for (String card : value) {
            int point = 0;
            if (card.startsWith("10")) {
                //силта и е 10
                char type = card.charAt(2);
                point= 10*symbolsValue.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);
                point = symbolsValue.get(power)*symbolsValue.get(type);
            }
             sum +=point;

        }
        return sum;
    }

    private static Map<Character, Integer> getSymbolsValue() {
        Map<Character, Integer> carachterValues = new HashMap<>();
        carachterValues.put('2', 2);
        carachterValues.put('3', 3);
        carachterValues.put('4', 4);
        carachterValues.put('5', 5);
        carachterValues.put('6', 6);
        carachterValues.put('7', 7);
        carachterValues.put('9', 9);
        carachterValues.put('J', 11);
        carachterValues.put('Q', 12);
        carachterValues.put('K', 13);
        carachterValues.put('A', 14);
        carachterValues.put('S', 4);
        carachterValues.put('H', 3);
        carachterValues.put('D', 2);
        carachterValues.put('C', 1);
      return carachterValues;
    }
}
