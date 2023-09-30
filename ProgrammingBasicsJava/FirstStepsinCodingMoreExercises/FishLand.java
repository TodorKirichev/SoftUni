package FirstStepsinCodingMoreExercises;

import java.util.Scanner;

public class FishLand {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceSkumriq = Double.parseDouble(scan.nextLine());
        double priceCaca = Double.parseDouble(scan.nextLine());
        double kgPalmud = Double.parseDouble(scan.nextLine());
        double kgSafrid = Double.parseDouble(scan.nextLine());
        int kgMidi = Integer.parseInt(scan.nextLine());

        double pricePalmud = kgPalmud*priceSkumriq*1.6;
        double priceSafrid = kgSafrid*priceCaca*1.8;
        double priceMidi = kgMidi*7.5;

        double sum = pricePalmud+priceSafrid+priceMidi;

        System.out.printf("%.2f",sum);




    }
}
