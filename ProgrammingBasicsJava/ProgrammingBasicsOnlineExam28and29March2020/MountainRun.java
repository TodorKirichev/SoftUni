package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double record = Double.parseDouble(scan.nextLine());
        double meters = Double.parseDouble(scan.nextLine());
        double secondsPerMeter = Double.parseDouble(scan.nextLine());

        double time = meters*secondsPerMeter;

        double delay = Math.floor(meters/50)*30;

        time+=delay;

        if (time<record){
            System.out.printf("Yes! The new record is %.2f seconds.",time);
        }else{
            System.out.printf("No! He was %.2f seconds slower.",time-record);
        }
    }
}
