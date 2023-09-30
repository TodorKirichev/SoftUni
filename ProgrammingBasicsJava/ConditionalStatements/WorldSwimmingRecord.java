package ConditionalStatements;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timePerMeter = Double.parseDouble(scan.nextLine());


        double delay = Math.floor(distance/15)*12.5;
        double timeIvan = (distance*timePerMeter)+delay;
        double diff = timeIvan-record;

        if (timeIvan<record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",timeIvan);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.",diff);
        }
    }
}
