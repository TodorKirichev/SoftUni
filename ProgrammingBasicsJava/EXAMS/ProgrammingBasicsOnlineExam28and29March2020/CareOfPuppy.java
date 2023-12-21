package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int kgFood = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int foodInGrams = kgFood*1000;

        while (!"Adopted".equals(input)){
            int grEaten = Integer.parseInt(input);
            foodInGrams-=grEaten;

            input= scan.nextLine();
        }
        if (foodInGrams>=0){
            System.out.printf("Food is enough! Leftovers: %d grams.",foodInGrams);
        }else{
            System.out.printf("Food is not enough. You need %d grams more.",Math.abs(foodInGrams));
        }
    }
}
