package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numBitcoins = Integer.parseInt(scan.nextLine());
        double numUan = Double.parseDouble(scan.nextLine());
        double comision = Double.parseDouble(scan.nextLine());

        double bitcoins = numBitcoins*1168;
        double uans = numUan*0.15*1.76;

        double euro = (bitcoins+uans) / 1.95;

        euro*=(100-comision)/100;

        System.out.printf("%.2f",euro);
    }
}
