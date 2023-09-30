package ConditionalStatements;

import java.util.Scanner;

public class Time15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int sum = (hours*60)+minutes+15;

        int hours2 = sum/60;
        int minutes2 = sum%60;

        if (hours2>=24) {
            hours2=0;
        }
        System.out.printf("%d:%02d",hours2,minutes2);
    }
}
