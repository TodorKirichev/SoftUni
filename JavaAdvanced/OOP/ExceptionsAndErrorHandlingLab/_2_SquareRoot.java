package SoftUni.JavaAdvanced.OOP.ExceptionsAndErrorHandlingLab;

import java.util.Scanner;

public class _2_SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number = scan.nextLine();

        getSquareRoot(number);
    }

    private static void getSquareRoot(String number) {
        int parsedNumber = 0;
        try {
            parsedNumber = Integer.parseInt(number);
            if (parsedNumber > 0) {
                double sqrt = Math.sqrt(parsedNumber);
                System.out.printf("%.2f\n",sqrt);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
