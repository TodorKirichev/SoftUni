package firtsStepsInPrograming;

import java.util.Scanner;

public class SuppliesforSchool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pens = Integer.parseInt(scan.nextLine());
        int markers = Integer.parseInt(scan.nextLine());
        int detergent = Integer.parseInt(scan.nextLine());
        int discount = Integer.parseInt(scan.nextLine());

        double pricePens = pens * 5.8;
        double priceMarkers = markers * 7.2;
        double pricePerLiter = detergent * 1.2;

        double sum = pricePens + priceMarkers + pricePerLiter - ((pricePens + priceMarkers + pricePerLiter)*discount/100);

        System.out.println(sum);
    }
}
