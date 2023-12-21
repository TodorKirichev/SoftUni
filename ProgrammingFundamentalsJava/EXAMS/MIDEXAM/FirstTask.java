package ProgrammingFundamentalsMidExam22October2023;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int players = Integer.parseInt(scan.nextLine());
        double energy = Double.parseDouble(scan.nextLine());
        double waterPerPerson = Double.parseDouble(scan.nextLine());
        double foodPerPerson = Double.parseDouble(scan.nextLine());

        double totalWater = waterPerPerson * days * players;
        double totalFood = foodPerPerson * days * players;
        boolean isEnough = true;

        for (int i = 1; i <= days; i++) {
            double lostEnergy = Double.parseDouble(scan.nextLine());
            energy -= lostEnergy;
            if (energy <=0){
                isEnough = false;
                break;
            }
            if (i % 2 == 0){
                energy *= 1.05;
                totalWater *= 0.7;
            }
            if (i % 3 == 0){
                energy *= 1.1;
                totalFood -= totalFood / players;
            }
        }
        if (isEnough){
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!",energy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",totalFood,totalWater);
        }
    }
}
