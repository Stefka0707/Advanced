package MultidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];


        //пълнене на патрицата
        fillMatrix(matrix, scanner);
        //сума на числата на главния диагонал
        // сума на чилата на второстепенният диагонал

        int sumFirst = getSumElementsOnPrimaryDiagonal(matrix);
        int sumSecondary = getSumElemntsOnSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumFirst - sumSecondary));

        // printMatrix(matrix);
    }

    private static int getSumElemntsOnSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            //може и (int row =0; row <matrix.length; row++)
            //итерира от о към последия ред, а горе итерира от последния към
            // първият ред;
            for (int col = 0; col < matrix[row].length; col++) {
                int currentElement = matrix[row][col];
                if (col == matrix.length - row - 1) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static int getSumElementsOnPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentElement = matrix[row][col];
                if (row == col) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
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
