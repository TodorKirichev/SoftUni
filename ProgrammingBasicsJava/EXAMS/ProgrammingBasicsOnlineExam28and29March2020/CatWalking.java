package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int minutesPerDay = Integer.parseInt(scan.nextLine());
        int walksPerDay = Integer.parseInt(scan.nextLine());
        int catCaloriesPerDay = Integer.parseInt(scan.nextLine());

        int caloriesBurn = walksPerDay*minutesPerDay*5;

        if (caloriesBurn>=catCaloriesPerDay/2){
            System.out.printf("Yes, the walk for your cat is enough. " +
                    "Burned calories per day: %d.",caloriesBurn);
        }else{
            System.out.printf("No, the walk for your cat is not enough. " +
                    "Burned calories per day: %d.",caloriesBurn);
        }
    }
}
