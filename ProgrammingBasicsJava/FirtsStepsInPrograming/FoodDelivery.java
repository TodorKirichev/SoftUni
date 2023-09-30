package firtsStepsInPrograming;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chiken = Integer.parseInt(scan.nextLine());
        int fish = Integer.parseInt(scan.nextLine());
        int vegan = Integer.parseInt(scan.nextLine());

        double priceChiken = chiken*10.35;
        double priceFish = fish*12.4;
        double priceVegan = vegan*8.15;
        double delivery = 2.5;
        double sum = priceChiken+priceFish+priceVegan;
        double dessert = sum*0.2;

        double priceOrder = sum+dessert+delivery;

        System.out.println(priceOrder);

    }
}
