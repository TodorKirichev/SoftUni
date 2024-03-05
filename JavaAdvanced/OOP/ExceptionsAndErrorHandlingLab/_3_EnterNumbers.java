package SoftUni.JavaAdvanced.OOP.ExceptionsAndErrorHandlingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _3_EnterNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        int start = 1;
        int end = 100;

        while (numbers.size() < 10){
            try {
                int number = readNumber(scan);
                if (number > start && number < end) {
                    numbers.add(number);
                } else {
                    System.out.printf("Your number is not in range %d - 100!\n",start);
                    continue;
                }
                start = number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            }
        }
        System.out.println(String.join(", ", numbers.stream().map(String::valueOf).collect(Collectors.toList())));
    }

    private static int readNumber(Scanner scan) {
        return Integer.parseInt(scan.nextLine());
    }
}
