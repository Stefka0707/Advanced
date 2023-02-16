package examPreparation;

import java.util.*;


public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int currRow = 0;
        int currCol = 0;
        int foodCount = 0;
        ArrayDeque<String> commandQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).forEach(commandQueue::offer);
        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input[j].charAt(0);
                if (matrix[i][j] == 's') {
                    matrix[i][j] = '*';
                    currRow = i;
                    currCol = j;
                }
                if (matrix[i][j] == 'f') {
                    foodCount++;
                }
            }
        }

        Map<String, Integer[]> directionMap = new HashMap<>();
        directionMap.put("up", new Integer[]{-1, 0});
        directionMap.put("down", new Integer[]{1, 0});
        directionMap.put("right", new Integer[]{0, 1});
        directionMap.put("left", new Integer[]{0, -1});

        int length = 1;
        boolean killed = false;
        while (!commandQueue.isEmpty() && !killed && foodCount!=0) {
            String currCommand = commandQueue.poll();
            int newRow = currRow + directionMap.get(currCommand)[0];
            int newCol = currCol + directionMap.get(currCommand)[1];
            if (!isIndexValid(newRow, newCol, size)) {
                if (newRow < 0) {
                    newRow = size - 1;
                } else if (newRow >= size) {
                    newRow = 0;
                } else if (newCol < 0) {
                    newCol = size - 1;
                } else if (newCol >= size) {
                    newCol = 0;
                }
            }

            char nextChar = matrix[newRow][newCol];

            switch (nextChar) {
                case '*':
                    currRow = newRow;
                    currCol = newCol;
                    break;
                case 'e':
                    killed = true;
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                case 'f':
                    length++;
                    foodCount--;
                    currRow = newRow;
                    currCol = newCol;
                    matrix[currRow][currCol] = '*';
                    break;
            }
        }

        if (foodCount > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
        } else if (foodCount <= 0) {
            System.out.printf("You win! Final python length is %d%n", length);
        }

    }

    public static boolean isIndexValid(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}