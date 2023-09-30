package firtsStepsInPrograming;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double deposit = Double.parseDouble(scan.nextLine());
        int period = Integer.parseInt(scan.nextLine());
        double rate = Double.parseDouble(scan.nextLine());

        double ratePerMonth = (deposit * rate/100)/12;


        double sum = deposit + period * ratePerMonth;
        System.out.println(sum);

    }
}
