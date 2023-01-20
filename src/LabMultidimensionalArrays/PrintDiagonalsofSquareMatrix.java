package LabMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsofSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowCol = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowCol][rowCol];


        for (int r = 0; r < rowCol; r++) {
            matrix[r] = readArray(scanner, "\\s+");
            for (int i = 0; i < matrix[r].length; i++) {
                int number = matrix[r][i];
                matrix[r][i] = number;
            }
        }
//        int row = 0;
//        int col = 0;
//        while (row < rowCol && col < rowCol) {
//
//            System.out.print(matrix[row++][col++] + " ");
//        }
//        System.out.println();
//        row = rowCol -1;
//        col= 0;
//
//        while (row >=0 && col<rowCol) {
//
//            System.out.print(matrix[row--][col++] + " ");
//        }
        //  АЛГОРИТЪМ за  отпечатаме всички диагонали
        int row = 0;
        int col = 0;
        while (row < rowCol) {
            int inerRow = row;
            int inerCol = col;
            while (inerCol < rowCol && inerCol < rowCol) {
                System.out.print(matrix[inerRow++][inerCol++] + " ");


            }
            System.out.println();
            col--;
            if (col < 0) {
                row++;
                col = 0;

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

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine()
                        .split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
