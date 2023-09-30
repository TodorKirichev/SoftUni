package ConditionalStatements;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceTour = Double.parseDouble(scan.nextLine());
        int numPuzzle = Integer.parseInt(scan.nextLine());
        int numDolls = Integer.parseInt(scan.nextLine());
        int numBears = Integer.parseInt(scan.nextLine());
        int numMinions = Integer.parseInt(scan.nextLine());
        int numTrucks = Integer.parseInt(scan.nextLine());

        double pricePuzzle = numPuzzle*2.60;
        double priceDolls = numDolls* 3;
        double priceBears = numBears* 4.10;
        double priceMinions = numMinions*8.20;
        double priceTrucks = numTrucks*2;

        double sumPrice = pricePuzzle+priceDolls+priceBears+priceMinions+priceTrucks;

        int sumToys = numPuzzle+numDolls+numBears+numMinions+numTrucks;

        if (sumToys>=50) {
            sumPrice = (sumPrice*0.75)*0.9;
        }else {
            sumPrice=sumPrice*0.9;
        }
        double result = Math.abs(sumPrice-priceTour);
        if (sumPrice>=priceTour) {
            System.out.printf("Yes! %.2f lv left.",result);
        }else {
            System.out.printf("Not enough money! %.2f lv needed.",result);
        }
    }

}
