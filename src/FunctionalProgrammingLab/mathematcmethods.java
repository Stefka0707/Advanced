package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class mathematcmethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int[] numbers ={13,42,69,73,21};

        Arrays.stream(numbers).forEach(n -> System.out.println(n + " " + isPrime(n)));

    }

    public static boolean isPrime(int number) {
        boolean isPrime = IntStream
                .range(2, number)
                .noneMatch(n -> isDivisibleBy(number, n));

        return isPrime && isGreaterThan(number,1);
    }

    public static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    public static boolean isGreaterThan(int first, int second) {
        return first > second;
    }
    public static boolean isEven(int number){
        return  isDivisibleBy(number,2);
    }

}

