package EXAM;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pocketMoneyPerDay = Double.parseDouble(scan.nextLine());
        double profitPerDay = Double.parseDouble(scan.nextLine());
        double expense = Double.parseDouble(scan.nextLine());
        double giftPrice = Double.parseDouble(scan.nextLine());

        double sum = (pocketMoneyPerDay+profitPerDay)*5;
        sum -= expense;

        if (sum >= giftPrice){
            System.out.printf("Profit: %.2f BGN, the gift has been purchased.",sum);
        }else{
            System.out.printf("Insufficient money: %.2f BGN.",giftPrice-sum);
        }
    }
}
