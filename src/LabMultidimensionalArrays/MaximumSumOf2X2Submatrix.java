package LabMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner, ", ");
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println(matrix[maxRow][maxCol]+" " + matrix[maxRow][maxCol+1]);
        System.out.println(matrix[maxRow+1][maxCol]+" " + matrix[maxRow+1][maxCol+1]);
        System.out.println(maxSum);

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

    private static int[][] readMatrix(Scanner scanner, String pattern) {
        int[] rowsAndCols = readArray(scanner, pattern);


        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner, pattern);

        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine()
                        .split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
