package SetsAndMapsLab;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> parking = new LinkedHashSet<>();// LinkedHashSet = подрежда ги по ред на въвъеждане

        String input = scanner.nextLine();

        while (! input.equals("END")){
           // String numberCar= input.split(", ")[1];
            String numberCar = input.substring(input.indexOf(",")+2);
            if (input.contains("IN")){
                parking.add(numberCar);
            }else {
                    parking.remove(numberCar);

            }

            input= scanner.nextLine();
        }
        if(parking.isEmpty()){

            System.out.println("Parking Lot is Empty");
        }
                else {

        String output = parking
                .stream()
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output);
        }
    }
}
