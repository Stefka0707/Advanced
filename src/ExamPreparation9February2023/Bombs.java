package ExamPreparation9February2023;

import java.util.*;


public class Bombs {
    public static final int DATURA_BOMBS = 40;
    public static final int CHERY_BOMBS = 60;
    public static final int SMOKE_DECOY_BOMBS = 120;

    private static final Map<Integer, String> possibleBomb = new HashMap<>() {{
        put(DATURA_BOMBS, "Datura Bombs");
        put(CHERY_BOMBS, "Cherry Bombs");
        put(SMOKE_DECOY_BOMBS, "Smoke Decoy Bombs");

    }};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effect = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(e -> effect.offer(e));
        ArrayDeque<Integer> casing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(e -> casing.push(e));

        Map<String, Integer> bombPouch = new TreeMap<>(Map.of("Datura Bombs",0,
                "Cherry Bombs",0,
                "Smoke Decoy Bombs",0));


        boolean haveMissingBomb = false;
        while (!effect.isEmpty() && !haveMissingBomb && !casing.isEmpty() ) {
            Integer numEffect = effect.peek();
            Integer numCasing = casing.pop();
            int possibleBombCost = numEffect + numCasing;
            String possibleBombMake = possibleBomb.get(possibleBombCost);
            // Ако стойността е била валидна т.е съвпада със стойност от мапа-> ще получа - стинга ястието
            //Ако стойността не е ила валидна ще получа null;
            if (possibleBombMake == null) {
                casing.push(numCasing - 5);

            } else {
                //bombPouch.put(possibleBombMake,bombPouch.get(possibleBombMake)+1);
                // което е
                int newCount = bombPouch.get(possibleBombMake) + 1;
                bombPouch.put(possibleBombMake, newCount);
                effect.poll();

            }
            //String resultString="";
            for (Integer value : bombPouch.values()) {
                //resultString = (value <3)? "false": "true";
                if (value < 3) {
                    haveMissingBomb = false;
                    break;
                } else {
                    haveMissingBomb = true;
                }
            }
        }
        // искам да питам дали някоя от стойностите в мапа е >3

        if (haveMissingBomb){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effect.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: ");
            System.out.println(effect.toString().replaceAll("[\\[\\]]", ""));
        }
        if (casing.isEmpty()){
            System.out.println("Bomb Casings: empty");

        }else {
            System.out.print("Bomb Casings: ");
            System.out.println(casing.toString().replaceAll("[\\[\\]]", ""));
        }
        bombPouch.forEach((k,v) -> System.out.println(k + ": " + v));

    }
}
