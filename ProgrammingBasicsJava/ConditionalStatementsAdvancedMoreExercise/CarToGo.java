package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String clas = "";
        String car = "";
        double rent = 0;

        if (budget<=100) {
            clas="Economy class";
            switch (season){
                case "Summer":
                    car="Cabrio";
                    rent=budget*0.35;
                    break;
                case "Winter":
                    car="Jeep";
                    rent=budget*0.65;
                    break;
            }

        } else if (budget>100&&budget<=500) {
            clas="Compact class";
            switch (season){
                case "Summer":
                    car="Cabrio";
                    rent=budget*0.45;
                    break;
                case "Winter":
                    car="Jeep";
                    rent=budget*0.8;
                    break;
            }

        }else {
            clas="Luxury class";
            car="Jeep";
            rent=budget*0.9;

        }
        System.out.println(clas);
        System.out.printf("%s - %.2f",car,rent);
    }
}
