package WhileLoopMoreExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int finalSum = Integer.parseInt(scan.nextLine());
        String command = "End";
        String input = scan.nextLine();
        double card = 0;
        double cash = 0;
        int counter = 1;
        int cardCounter = 0;
        int cashCounter = 0;

        while (!input.equals(command)){
            int sum = Integer.parseInt(input);
            if (counter%2==0){
                if (sum<10){
                    System.out.println("Error in transaction!");
                }else{
                    card+=sum;
                    cardCounter++;
                    System.out.println("Product sold!");
                }
            }else{
                if (sum>100){
                    System.out.println("Error in transaction!");

                }else {
                    cash+=sum;
                    cashCounter++;
                    System.out.println("Product sold!");
                }
            }
            counter++;

            if (finalSum<=card+cash){
                break;
            }
            input = scan.nextLine();

        }
        if (finalSum<=card+cash){
            System.out.printf("Average CS: %.2f%n",cash/cashCounter);
            System.out.printf("Average CC: %.2f%n",card/cardCounter);

        }else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
