package ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        double kmPerMonth = Double.parseDouble(scan.nextLine());
        double salary = 0;

        switch (season){
            case "Spring":
            case "Autumn":
                if (kmPerMonth<=5000){
                    salary=kmPerMonth*0.75;
                }
                else if (kmPerMonth>5000&&kmPerMonth<=10000){
                    salary=kmPerMonth*0.95;
                }
                else if (kmPerMonth>10000&&kmPerMonth<=20000){
                    salary=kmPerMonth*1.45;
                }
                break;
            case "Summer":
                if (kmPerMonth<=5000){
                    salary=kmPerMonth*0.9;
                }
                else if (kmPerMonth>5000&&kmPerMonth<=10000){
                    salary=kmPerMonth*1.1;
                }
                else if (kmPerMonth>10000&&kmPerMonth<=20000){
                    salary=kmPerMonth*1.45;
                }
                break;
            case "Winter":
                if (kmPerMonth<=5000){
                salary=kmPerMonth*1.05;
            }
                else if (kmPerMonth>5000&&kmPerMonth<=10000){
                    salary=kmPerMonth*1.25;
                }
                else if (kmPerMonth>10000&&kmPerMonth<=20000){
                    salary=kmPerMonth*1.45;
                }
                break;
        }
        salary*=4*0.9;
        System.out.printf("%.2f",salary);
    }
}
