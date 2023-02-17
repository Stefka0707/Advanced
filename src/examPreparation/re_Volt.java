package examPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class re_Volt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberCommands = Integer.parseInt(scanner.nextLine());

        Map<String, Integer[]> directionMap = new HashMap<>();
        directionMap.put("up", new Integer[]{-1, 0});
        directionMap.put("down", new Integer[]{1, 0});
        directionMap.put("right", new Integer[]{0, 1});
        directionMap.put("left", new Integer[]{0, -1});
        char[][] matrix = new char[size][size];
        int currRow = 0;
        int currCol = 0;
        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input[j].charAt(0);
                if (matrix[i][j] == 'f') {
                    matrix[i][j] = '-';
                    currRow = i;
                    currCol = j;
                }
            }
        }
        while (numberCommands-- >0) {
            String direction = scanner.nextLine();
            int newRow = currRow + directionMap.get(direction)[0];
            int newCol = currCol + directionMap.get(direction)[1];
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
            char charr = matrix[newRow][newCol];
            if (charr == 'B') {
                currRow = newRow;
                currCol = newCol;
                newRow = currRow + directionMap.get(direction)[0];
                newCol = currCol + directionMap.get(direction)[1];
                currRow = newRow;
                currCol = newCol;
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



            if (matrix[newRow][newCol]== 'T') {

                continue;
            } else if (matrix[newRow][newCol]== '-') {
                currRow = newRow;
                currCol = newCol;
                continue;
            } else if (matrix[newRow][newCol]=='F') {
                matrix[newRow][newCol] = '-';
                currRow = newRow;
                currCol = newCol;
                matrix[currRow][currCol] = 'f';
                System.out.println("Player won!");
                printMatrix(matrix);
                return;
            }

        }
        matrix[currRow][currCol] = 'f';
        System.out.println("Player lost!");
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            //  int []arr = matrix[row];// ако не извеждаме променлива може направо
            // във вложения цикъл вместо arr - > да направим matrix[row];
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");

            }
            System.out.println();
        }
    }

    public static boolean isIndexValid(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
