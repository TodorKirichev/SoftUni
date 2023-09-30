package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class Series {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int numSerials = Integer.parseInt(scan.nextLine());
        double finalPrice = 0;

        for (int i = 0; i < numSerials; i++) {

            String serialName = scan.nextLine();
            double serialPrice = Double.parseDouble(scan.nextLine());

            switch (serialName){
                case "Thrones":
                    serialPrice*=0.5;
                    break;
                case "Lucifer":
                    serialPrice*=0.6;
                    break;
                case "Protector":
                    serialPrice*=0.7;
                    break;
                case "TotalDrama":
                    serialPrice*=0.8;
                    break;
                case "Area":
                    serialPrice*=0.9;
                    break;
            }
            finalPrice+=serialPrice;
        }
        if (budget>=finalPrice){
            System.out.printf("You bought all the series and left with %.2f lv.",budget-finalPrice);
        }else {
            System.out.printf("You need %.2f lv. more to buy the series!",finalPrice-budget);
        }
    }
}
