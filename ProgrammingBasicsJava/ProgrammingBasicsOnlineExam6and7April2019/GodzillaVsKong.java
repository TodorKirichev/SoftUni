package ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int statists = Integer.parseInt(scan.nextLine());
        double statistSuitPrice = Double.parseDouble(scan.nextLine());

        budget *= 0.9;
        if (statists>150){
            statistSuitPrice *= 0.9;
        }
        budget-=statists*statistSuitPrice;
        if (budget<0){
            System.out.printf("Not enough money!%n");
            System.out.printf("Wingard needs %.2f leva more.",Math.abs(budget));
        }else{
            System.out.printf("Action!%n");
            System.out.printf("Wingard starts filming with %.2f leva left.",budget);
        }
    }
}
