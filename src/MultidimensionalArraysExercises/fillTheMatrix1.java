package MultidimensionalArraysExercises;

import java.util.Scanner;

public class fillTheMatrix1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix);

        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);

        }
        printMatrix(matrix);

    }
    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 != 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;

                }
            } else {
                for (int row = 0; row <= matrix.length - 1; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;


                }
            }

        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;

            }

        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            //  int []arr = matrix[row];// ако не извеждаме променлива може направо
            // във вложения цикъл вместо arr - > да направим matrix[row];
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }
}
