package ConditionalStatements;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int statists = Integer.parseInt(scan.nextLine());
        double costumePrice = Double.parseDouble(scan.nextLine());

        double decor = budget*0.1;
        double costume = statists*costumePrice;

        if (statists>150) {
            costume=costume-costume*0.1;
        } double sum = decor+costume;
        double diff = Math.abs(sum-budget);
        if (sum>budget) {
            System.out.printf("Not enough money!%n");
            System.out.printf("Wingard needs %.2f leva more.",diff);
        } else {
            System.out.printf("Action!%n");
            System.out.printf("Wingard starts filming with %.2f leva left.",diff);
        }
    }

}
