package LabMultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];


        for (int r = 0; r < n; r++) {
            matrix[r] = readArray(scanner, "\\s+");

        }
        int [] indexes = readArray(scanner,"\\s+");
        int wrongValue = matrix[indexes[0]][indexes[1]];
        ArrayList<int[]>corect = new ArrayList<>();


        for (int row = 0; row <matrix.length; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                if (matrix[row][col] == wrongValue){
                    int rightValue = calculateRightValue(matrix, wrongValue, row, col);
                corect.add(new int[] {row,col,rightValue});
                }
            }

        }


        for (int[] ints : corect) {
            matrix[ints[0]][ints[1]] = ints[2];

        }
        printMatrix(matrix);
    }

    private static int calculateRightValue(int[][] matrix, int wrongValue, int row, int col) {
        int rightValue = 0;
        if (isInBounds(matrix,row - 1, col) && matrix[row -1][col] !=wrongValue){
        rightValue +=matrix[row -1][col];
        }
        if (isInBounds(matrix,row +1,col) && matrix[row +1][col] !=wrongValue){
        rightValue +=matrix[row +1][col];

        }
        if (isInBounds(matrix,row,col -1) && matrix[row ][col-1] !=wrongValue){
        rightValue +=matrix[row ][col-1];

        }
        if (isInBounds(matrix,row,col +1) && matrix[row ][col+1] !=wrongValue){
        rightValue +=matrix[row ][col +1];

        }

        return rightValue;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row <matrix.length && row >=0 && col < matrix[row].length && col >=0;
    }
    private static boolean isOutOfBounds(int [][] matrix,int row, int col){
        return (!isInBounds(matrix,row,col));
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

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine()
                        .split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
