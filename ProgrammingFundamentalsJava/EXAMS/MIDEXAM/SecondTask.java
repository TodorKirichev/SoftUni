package ProgrammingFundamentalsMidExam22October2023;

import java.util.Arrays;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] vehicles = (scan.nextLine().split(">>"));
        double totalTax = 0;

        for (int i = 0; i < vehicles.length; i++) {

            String [] input = vehicles[i].split(" ");

            String carType = input[0];
            if (!carType.equals("family") && !carType.equals("heavyDuty") && !carType.equals("sports")){
                System.out.println("Invalid car type.");
                continue;
            }
            int years = Integer.parseInt(input[1]);
            int kilometers = Integer.parseInt(input[2]);

            double taxes = 0;
            int initialTax = 0;
            int timesTaxIncrease = 0;
            int taxDeclined = 0;

            if (carType.equals("family")){
                initialTax = 50;
                timesTaxIncrease = kilometers / 3000 ;
                taxDeclined = years * 5;
                taxes = timesTaxIncrease * 12 + (initialTax - taxDeclined);
            } else if (carType.equals("heavyDuty")) {
                initialTax = 80;
                timesTaxIncrease = kilometers / 9000 ;
                taxDeclined = years * 8;
                taxes = timesTaxIncrease * 14 + (initialTax - taxDeclined);
            } else {
                initialTax = 100;
                timesTaxIncrease = kilometers / 2000 ;
                taxDeclined = years * 9;
                taxes = timesTaxIncrease * 18 + (initialTax - taxDeclined);
            }
            System.out.printf("A %s car will pay %.2f euros in taxes.%n",carType,taxes);
            totalTax += taxes;
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n",totalTax);
    }
}
