package ForLoopMoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numLoads = Integer.parseInt(scan.nextLine());
        int bus = 0;
        int truck = 0;
        int train = 0;
        double busPrice = 0;
        double truckPrice = 0;
        double trainPrice = 0;
        int loads = 0;

        for (int i = 0; i < numLoads; i++) {
            int tons=Integer.parseInt(scan.nextLine());
            loads+=tons;
            if (tons<=3){
                busPrice+=tons*200;
                bus+=tons;
            } else if (tons<=11) {
                truckPrice+=tons*175;
                truck+=tons;
            }else {
                trainPrice+=tons*120;
                train+=tons;
            }
        }
        double midPrice=(busPrice+truckPrice+trainPrice)/loads;

        System.out.printf("%.2f%n",midPrice);
        System.out.printf("%.2f%%%n",(double)bus/loads*100);
        System.out.printf("%.2f%%%n",(double)truck/loads*100);
        System.out.printf("%.2f%%%n",(double)train/loads*100);
    }
}
