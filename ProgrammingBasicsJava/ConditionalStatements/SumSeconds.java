package ConditionalStatements;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int time1 = Integer.parseInt(scan.nextLine());
        int time2 = Integer.parseInt(scan.nextLine());
        int time3 = Integer.parseInt(scan.nextLine());

        int sum = time1+time2+time3;

        int min = sum/60;
        int sec = sum%60;

        System.out.printf("%d:%02d",min,sec);


    }
}
