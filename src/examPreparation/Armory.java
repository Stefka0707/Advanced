package examPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        List<Integer> coordinates = new ArrayList<>();

        int coins = 65;
        int biy = 0;

        fillMatrixString(matrix, scanner);
        int currentRow = -1;
        int currentCol = -1;
        int newtRow = -1;
        int newtCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("A")) {
                    currentRow = row;
                    currentCol = col;
                    newtRow=row;
                            newtCol=col;
                    break;
                }
            }
        }

        findCoordinates(matrix, coordinates);
        boolean isOut = false;
        String command = scanner.nextLine();
        while (AreIndexesValid(currentRow, currentCol, matrix)) {
            switch (command) {
                case "up":
                    if (currentRow - 1 >= 0) {
                        newtRow = currentRow;
                        currentRow--;


                    } else {
                        isOut = true;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
                case "down":
                    if (currentRow + 1 < size) {
                        currentRow++;
                        newtRow = currentRow -1;

                    } else {
                        isOut = true;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
                case "left":
                    if (currentCol - 1 >= 0) {
                       newtCol=currentCol;
                        currentCol--;

                    } else {
                        isOut = true;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
                case "right":
                    if (currentCol + 1 < size) {
                       newtCol =currentCol;
                        currentCol++;

                    } else {
                        isOut = true;
                        matrix[currentRow][currentCol] = "-";
                    }
                    break;
            }

            if (matrix[currentRow][currentCol].equals("M")) {
                currentRow = coordinates.get(2);
                currentCol = coordinates.get(3);
                matrix[currentRow][currentCol]= "A";
                matrix[newtRow][newtCol]="-";

            } else if (!matrix[currentRow][currentCol].equals("-")) {
                int price = Integer.parseInt(matrix[currentRow][currentCol]);
                coins -= price;
                biy += price;
                matrix[currentRow][currentCol]= "A";
                matrix[newtRow][newtCol]="-";

            }

            if (isOut) {
                System.out.println("I do not need more swords!");
                break;
            } else if (coins < 0) {
                System.out.println("Very nice swords, I will come back for more!");
                break;
            } else {
                command = scanner.nextLine();
            }
        }
        System.out.printf("The king paid %d gold coins. %n", biy);
        printMatrix(matrix);

    }

    private static boolean AreIndexesValid(int row, int col, String[][] matrix) {
        return (row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length);
    }

    private static void fillMatrixString(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = scanner.nextLine().split("");

        }
    }

    private static void findCoordinates(String[][] matrix, List<Integer> coordinates) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String currentElement = matrix[row][col];
                if (currentElement.equals("M")) {
                    coordinates.add(row);
                    coordinates.add(col);
                }

            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            //  int []arr = matrix[row];// ако не извеждаме променлива може направо
            // във вложения цикъл вместо arr - > да направим matrix[row];
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");

            }
            System.out.println();
        }

    }
}
