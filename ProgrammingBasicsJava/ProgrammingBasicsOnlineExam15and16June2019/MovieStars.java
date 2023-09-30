package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class MovieStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();

        while (!"ACTION".equals(input)){
            String actorName = input;
            if (actorName.length()>15){
                budget-=budget*0.2;
            }else{
                double honorar = Double.parseDouble(scan.nextLine());
                budget-=honorar;
            }
            if (budget<=0){
                break;
            }

            input= scan.nextLine();
        }
        if (budget>=0){
            System.out.printf("We are left with %.2f leva.",budget);
        }else{
            System.out.printf("We need %.2f leva for our actors.",Math.abs(budget));
        }
    }
}
