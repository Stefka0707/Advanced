package SetsAndMapsLab;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String,double[]> studentsWithGrates = new TreeMap<>();

        while (n-- > 0){
            String name= scanner.nextLine();
            double [] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            //mapToDouble дава примитивния double-ако сме дали само mapToDouble
            // - правим .mapToDouble(Double::parseDouble).boxed().toArray-за да получим класа Double
            //map дава класа Double  -

         studentsWithGrates.put(name,grades);
        }
        studentsWithGrates.forEach((k,v) -> {
        System.out.printf("%s is graduated with %f%n",k,Arrays.stream(v).average().orElse(9));

        });
    }
}
