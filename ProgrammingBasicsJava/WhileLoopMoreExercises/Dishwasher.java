package WhileLoopMoreExercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bottles = Integer.parseInt(scan.nextLine());
        String command = "End";
        int detergent = bottles*750;
        String input = scan.nextLine();
        int counter = 1;
        int pots = 0;
        int plates = 0;

        while (!input.equals(command)){
            int dishes = Integer.parseInt(input);
            if (counter%3==0){
                detergent-=dishes*15;
                pots+=dishes;
            }else{
                detergent-=dishes*5;
                plates+=dishes;
            }
            if (detergent<0){
                break;
            }
                counter ++;
            input= scan.nextLine();
        }
        if (detergent<0){
            System.out.printf("Not enough detergent, %d ml. more necessary!",Math.abs(detergent));
        }else{
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n",plates,pots);
            System.out.printf("Leftover detergent %d ml.",detergent);
        }
    }
}
