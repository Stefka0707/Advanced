package SetsandMapsExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //username -> списък на всички ip
        // за всяко ип -> брой на влизанията

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();

        while (!input.equals("end")) {
            // input = IP={IP.Address} message={A&sample&message} user={username}"
            String ip = input.split("\\s+")[0].split("=")[1];
            String message = input.split("\\s+")[1].split("=")[1];
            String userName = input.split("\\s+")[2].split("=")[1];

            input = scanner.nextLine();
        }
    }
}
