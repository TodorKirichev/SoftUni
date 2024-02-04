package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionLab._4_HotelReservation;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        System.out.printf("%.2f",calculatePrice(scan));
    }

    private static double calculatePrice(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int numOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(input[3]);

        return PriceCalculator.calculate(pricePerDay,numOfDays,season,discountType);
    }
}
