package ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String companyName = scan.nextLine();
        int numAdultTicket = Integer.parseInt(scan.nextLine());
        int numKidTicket = Integer.parseInt(scan.nextLine());
        double adultPriceNet = Double.parseDouble(scan.nextLine());
        double tax = Double.parseDouble(scan.nextLine());

        double kidPrice = adultPriceNet*0.3+tax;
        double adultPrice = adultPriceNet+tax;

        double profit = (kidPrice*numKidTicket+adultPrice*numAdultTicket)*0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",companyName,profit);
    }
}
