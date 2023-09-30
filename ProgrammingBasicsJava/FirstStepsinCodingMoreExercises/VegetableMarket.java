package FirstStepsinCodingMoreExercises;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double vegePrice = Double.parseDouble(scan.nextLine());
        double fruitPrice = Double.parseDouble(scan.nextLine());
        int vegeAmoount = Integer.parseInt(scan.nextLine());
        int fruitAmount = Integer.parseInt(scan.nextLine());

        double vegetables = vegePrice*vegeAmoount;
        double fruit = fruitAmount*fruitPrice;

        double sum = (vegetables+fruit)/1.94;

        System.out.printf("%.2f",sum);
    }
}
