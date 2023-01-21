package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rallyracing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String carNumber = scanner.nextLine();
        String[][] trace = new String[n][n];
        int km = 0;// изминати км от колата;
        int countTunnels = 0;

        fillStringMatrix(trace, scanner);

        int currentRow = 0; // ред, на който се намира колата
        int currentCol = 0;// колона, на който се намира колата

        // намиране тунелите -> по условие е казано, че са два тунела
        // тунел 1 -> ред , колона
        // тунел 2 -> ред,колона
        // за да съхраним координатите -> правим ArrayList
        // 4 елемента в масива -1 елемент (ред на тунел1)
        // 2 елемент(колона на тунел1)
        //3 елемент(ред на тунел2)
        //4 елемент(колона на тунел2)

        List<Integer> tunnelCoordinate = new ArrayList<>();
        findTunnels(trace, tunnelCoordinate);
        //започваме движение
        String direction = scanner.nextLine();

        while (!direction.equals("End")) {
            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            String movedPlace = trace[currentRow][currentCol];
            if (".".equals(movedPlace)) {
                km += 10;
            } else if ("F".equals(movedPlace)) {
                km += 10;
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                break;
            } else if (movedPlace.equals("T")) {
                countTunnels++;
                if (countTunnels == 1) {
                    currentRow = tunnelCoordinate.get(2);
                    currentCol = tunnelCoordinate.get(3);
                    km += 30;
                    //заместваме тунелите с .
                    trace[tunnelCoordinate.get(0)][tunnelCoordinate.get(1)] = ".";
                    trace[tunnelCoordinate.get(2)][tunnelCoordinate.get(3)] = ".";

                }

            }
            direction = scanner.nextLine();

        }
        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.\n", carNumber);

        }
        System.out.printf("Distance covered %d km.\n", km);
        trace[currentRow][currentCol] = "C";
        printMatrix(trace);


    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelCoordinate) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace[row].length; col++) {
                String currentElement = trace[row][col];
                if (currentElement.equals("T")) {
                    tunnelCoordinate.add(row);
                    tunnelCoordinate.add(col);
                }


            }
        }
    }

    private static void fillStringMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = scanner.nextLine().split("\\s+");

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
