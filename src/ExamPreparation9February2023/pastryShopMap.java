package ExamPreparation9February2023;

import java.util.*;



public class pastryShopMap {
    public static final int BISCUIT_VALUE = 25;

    public static final int CAKE_VALUE = 50;
    public static final int PASTRY_VALUE = 75;
    public static final int PIE_VALUE = 100;
    private static final Map<Integer, String> costToDish = new HashMap<>() {{
        put(BISCUIT_VALUE, "Biscuit");
        put(CAKE_VALUE, "Cake");
        put(PASTRY_VALUE, "Pastry");
        put(PIE_VALUE, "Pie");
    }};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //a може да си направим мапове за да ги пазим

        String[] liquidInfo = scanner.nextLine().split("\\s+");
        Deque<Integer> liquids = new ArrayDeque<>();

        for (String liquid : liquidInfo) {
            liquids.offer(Integer.parseInt(liquid));

        }
        String[] ingredientsInfo = scanner.nextLine().split("\\s+");

        Deque<Integer> ingredients = new ArrayDeque<>();

        for (String ingredient : ingredientsInfo) {
            ingredients.push(Integer.parseInt(ingredient));
        }


        Map<String, Integer> dishCount = new LinkedHashMap<>()
        {
            {
                //за да са в определения ред ги подаваме тук
                put("Biscuit", 0);
                put("Cake", 0);
                put("Pie", 0);
               put("Pastry", 0);
            }
        };
        int biscuitCount = 0, cakeCount = 0, pastryCount = 0, pieCount = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            Integer liquid = liquids.poll();
            Integer ingredient = ingredients.pop();
            int possibleDishCost = liquid + ingredient;
            String possibleDish = costToDish.get(possibleDishCost);
            // Ако стойността е била валидна т.е съвпада със стойност от мапа-> ще получа - стинга ястието
            //Ако стойността не е ила валидна ще получа null;
            if (possibleDish == null) {
                ingredients.push(ingredient + 3);
            } else {
                //dishCount.put(possibleDish,dishCount.get(possibleDish)+1);
                // което е
                int newCount = dishCount.get(possibleDish) + 1;
                dishCount.put(possibleDish, newCount);
            }
        }
        // искам да питам дали някоя от стойностите в мапа е 0
        boolean haveMissingDish = dishCount.containsValue(0);

        if (haveMissingDish) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }

        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(String.join(", ", ingredients.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        dishCount.forEach((k,v) -> System.out.println(k + ": " + v));
       // System.out.printf("Biscuit: %d\nCake: %d\nPie: %d\nPastry: %d\n", biscuitCount, cakeCount, pieCount, pastryCount);

    }
}

