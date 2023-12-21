package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class PoolDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pplNum = Integer.parseInt(scan.nextLine());
        double taxEntry = Double.parseDouble(scan.nextLine());
        double taxSunbed = Double.parseDouble(scan.nextLine());
        double taxUmbrella = Double.parseDouble(scan.nextLine());

        double sumEntry =pplNum*taxEntry;
        double sumSunbed = Math.ceil(pplNum*0.75)*taxSunbed;
        double sumUmbrella = Math.ceil((double) pplNum /2)*taxUmbrella;

        System.out.printf("%.2f lv.",sumEntry+sumSunbed+sumUmbrella);
    }
}
