package firtsStepsInPrograming;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nylon = Integer.parseInt(scan.nextLine());
        int paint = Integer.parseInt(scan.nextLine());
        int diluent = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());
        double bag = 0.4;

        double priceNylon = (nylon + 2) * 1.5;
        double pricePaint = (paint * 1.1) * 14.5;
        double priceDiluent = diluent * 5;
        double priceWorkers = hours * (priceNylon+priceDiluent+pricePaint+bag)*0.3;

        double sum = priceNylon+priceDiluent+pricePaint+priceWorkers+bag;
        System.out.println(sum);




    }
}
