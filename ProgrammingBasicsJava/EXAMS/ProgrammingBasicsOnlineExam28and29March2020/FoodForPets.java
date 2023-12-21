package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        double food = Double.parseDouble(scan.nextLine());
        int dogFood = 0;
        int catFood = 0;
        double biscuits = 0;

        for (int i = 1; i <= days; i++) {
            int dog = Integer.parseInt(scan.nextLine());
            int cat = Integer.parseInt(scan.nextLine());
            dogFood+=dog;
            catFood+=cat;
            if (i%3==0){
                biscuits+=(dog+cat)*0.1;
            }
        }
        double sum = dogFood+catFood;

        System.out.printf("Total eaten biscuits: %dgr.%n",Math.round(biscuits));
        System.out.printf("%.2f%% of the food has been eaten.%n",sum/food*100);
        System.out.printf("%.2f%% eaten from the dog.%n",dogFood/sum*100);
        System.out.printf("%.2f%% eaten from the cat.%n",catFood/sum*100);
    }
}
