package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String drinkType = scan.nextLine();
        String sugar = scan.nextLine();
        int numDrinks = Integer.parseInt(scan.nextLine());
        double price = 0;

        switch (drinkType){
            case "Espresso":
                switch (sugar){
                    case "Without":
                        price=0.9*numDrinks*0.65;
                        break;
                    case "Normal":
                        price=1*numDrinks;
                        break;
                    case "Extra":
                        price=1.2*numDrinks;
                        break;
                }
                if (numDrinks>=5){
                    price*=0.75;
                }

                break;
            case "Cappuccino":
                switch (sugar){
                    case "Without":
                        price=1*numDrinks*0.65;
                        break;
                    case "Normal":
                        price=1.2*numDrinks;
                        break;
                    case "Extra":
                        price=1.6*numDrinks;
                        break;
                }

                break;
            case "Tea":
                switch (sugar){
                    case "Without":
                        price=0.5*numDrinks*0.65;
                        break;
                    case "Normal":
                        price=0.6*numDrinks;
                        break;
                    case "Extra":
                        price=0.7*numDrinks;
                        break;
                }

                break;
        }
        if (price>15){
            price*=0.8;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.",numDrinks,drinkType,price);
    }
}
