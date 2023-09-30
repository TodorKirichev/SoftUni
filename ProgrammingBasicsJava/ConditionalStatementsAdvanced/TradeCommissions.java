package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String town = scan.nextLine();
        double amount = Double.parseDouble(scan.nextLine());

        double s = 0;
        boolean isValid = true;

        switch (town) {
            case "Sofia":
                if (amount>=0 && amount<=500){
                    s=0.05;
                } else if (amount>500 && amount<=1000) {
                    s=0.07;
                } else if (amount>1000 && amount <=10000) {
                    s=0.08;
                } else if (amount>10000) {
                    s=0.12;
                } else if (amount<0) {
                    isValid=false;
                }
                break;
            case "Varna":
                if (amount>=0 && amount<=500){
                    s=0.045;
                } else if (amount>500 && amount<=1000) {
                    s=0.075;
                } else if (amount>1000 && amount <=10000) {
                    s=0.10;
                } else if (amount>10000) {
                    s=0.13;
                } else if (amount<0) {
                    isValid=false;
                }
                break;
            case "Plovdiv":
                if (amount>=0 && amount<=500){
                    s=0.055;
                } else if (amount>500 && amount<=1000) {
                    s=0.08;
                } else if (amount>1000 && amount <=10000) {
                    s=0.12;
                } else if (amount>10000) {
                    s=0.145;
                } else if (amount<0) {
                    isValid=false;
                }
                break;
            default:
                isValid=false;
                break;

        } double commission = amount * s ;

        if (isValid) {

            System.out.printf("%.2f",commission);
        } else {
            System.out.printf("error");
        }
    }
}
