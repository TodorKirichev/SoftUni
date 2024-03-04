package SoftUni.JavaAdvanced.OOP.ExceptionsAndErrorHandlingLab;

import java.util.Scanner;

public class _1_NumberInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] range = scan.nextLine().split("\\s+");
        int min = Integer.parseInt(range[0]);
        int max = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]\n", min, max);

        int num = parse(scan, min, max);

        System.out.printf("Valid number: %d",num);
    }

    private static int parse(Scanner scan, int min, int max) {
        while (true) {
            String number = scan.nextLine();
            try {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber >= min && parsedNumber <= max) {
                    return parsedNumber;
                }
            } catch (NumberFormatException e) {
            }
            System.out.printf("Invalid number: %s\n", number);
        }
    }
}
