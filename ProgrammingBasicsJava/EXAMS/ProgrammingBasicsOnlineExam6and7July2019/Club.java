package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double desiredProfit = Double.parseDouble(scan.nextLine());
        String coctailName = scan.nextLine();

        double profit = 0;

        while (!coctailName.equals("Party!")){

            int numCoctails=Integer.parseInt(scan.nextLine());
            double coctailPrice = coctailName.length()*numCoctails;
            if (coctailPrice%2!=0){
                coctailPrice*=0.75;
            }

            profit+=coctailPrice;
            if (profit>=desiredProfit){
                break;
            }

            coctailName= scan.nextLine();


        }
        if (profit<desiredProfit) {
            System.out.printf("We need %.2f leva more.%n",desiredProfit-profit);
            System.out.printf("Club income - %.2f leva.",profit);
        }else if (profit>=desiredProfit){
            System.out.printf("Target acquired.%n");
            System.out.printf("Club income - %.2f leva.",profit);
        }
    }
}
