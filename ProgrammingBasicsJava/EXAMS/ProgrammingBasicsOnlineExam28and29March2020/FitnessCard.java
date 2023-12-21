package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String gender = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String sport = scan.nextLine();
        double cardPrice = 0;

        switch (gender){
            case "m":
                switch (sport){
                    case "Gym":
                        cardPrice=42;
                        break;
                    case "Boxing":
                        cardPrice=41;
                        break;
                    case "Yoga":
                        cardPrice=45;
                        break;
                    case "Zumba":
                        cardPrice=34;
                        break;
                    case "Dances":
                        cardPrice=51;
                        break;
                    case "Pilates":
                        cardPrice=39;
                        break;
                }
                break;
            case "f":
                switch (sport){
                    case "Gym":
                        cardPrice=35;
                        break;
                    case "Boxing":
                        cardPrice=37;
                        break;
                    case "Yoga":
                        cardPrice=42;
                        break;
                    case "Zumba":
                        cardPrice=31;
                        break;
                    case "Dances":
                        cardPrice=53;
                        break;
                    case "Pilates":
                        cardPrice=37;
                        break;
                }
                break;
        }
        if (age<=19){
            cardPrice*=0.8;
        }
        if (budget>=cardPrice){
            System.out.printf("You purchased a 1 month pass for %s.",sport);
        }else{
            System.out.printf("You don't have enough money! You need $%.2f more.",cardPrice-budget);
        }
    }
}
