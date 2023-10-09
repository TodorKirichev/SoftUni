package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Vacation_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numPeople = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String day = scan.nextLine();
        double price = 0;

        switch (day){
            case "Friday":
                switch (groupType){
                    case "Students":
                        price=8.45;
                        if (numPeople>=30){
                            price = price*0.85;
                        }
                        break;
                    case "Business":
                        price=10.9;
                        if (numPeople>=100) {
                            numPeople -= 10;
                        }
                        break;
                    case "Regular":
                        price=15;
                        if (numPeople >= 10 && numPeople <= 20) {
                            price = price * 0.95;
                        }
                        break;
                }
                break;
            case "Saturday":
                switch (groupType){
                    case "Students":
                        price=9.8;
                        if (numPeople>=30){
                            price = price*0.85;
                        }
                        break;
                    case "Business":
                        price=15.6;
                        if (numPeople>=100) {
                            numPeople -= 10;
                        }
                        break;
                    case "Regular":
                        price=20;
                        if (numPeople >= 10 && numPeople <= 20) {
                            price = price * 0.95;
                        }
                        break;
                }
                break;
            case "Sunday":
                switch (groupType){
                    case "Students":
                        price=10.46;
                        if (numPeople>=30){
                            price = price*0.85;
                        }
                        break;
                    case "Business":
                        price=16;
                        if (numPeople>=100) {
                            numPeople -= 10;
                        }
                        break;
                    case "Regular":
                        price=22.5;
                        if (numPeople >= 10 && numPeople <= 20) {
                            price = price * 0.95;
                        }
                        break;
                }
                break;
        }

        System.out.printf("Total price: %.2f",price * numPeople);
    }
}
