package LabMultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                int number = Integer.parseInt(tokens[i]);
                matrix[row][i] = number;
            }
        }
        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<int[]> position = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    //int [] indexes = new int[2];
                    //indexes[0]=row;
                    // indexes[1]=col;
                    //за да си спестим горното правим:
                    int[] indexes = {row, col};
                    position.add(indexes);

                }
            }
        }
        if (position.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] positions : position) {
                System.out.println(positions[0] + " " + positions[1]);

            }
        }

    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);
        //След като това ще го ползваме отново
        //за да прочетем и следващата мартица правим:
        // маркираме стрийма без името на променливата демек след равното маркираме
        // ->десен бутон -> refactor ->
        // extract method ->

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);

        }
        return matrix;
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

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
