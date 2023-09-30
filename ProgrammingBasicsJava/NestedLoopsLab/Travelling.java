package NestedLoopsLab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String destination = scan.nextLine();

        while (!destination.equals("End")){
            double minBudget = Double.parseDouble(scan.nextLine());
            double savedMoney = 0;
            while (savedMoney<minBudget){
                double input = Double.parseDouble(scan.nextLine());
                savedMoney+=input;
                if (savedMoney>=minBudget){
                    System.out.printf("Going to %s!%n",destination);
                    break;
                }
            }
            destination = scan.nextLine();
        }
    }
}
