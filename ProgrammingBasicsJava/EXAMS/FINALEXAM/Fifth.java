package EXAM;

import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int startMeters = 5364;
        int everest = 8848;
        int countDays = 0;
        int countNights = 0;

        while (!"END".equals(input)){

            countDays++;
            String choice = input;
            if (choice.equals("Yes")){
                countNights++;
                if (countNights>=5){
                    System.out.printf("Failed!%n");
                    System.out.printf("%d",startMeters);
                    return;
                }
            }
            int climbMeters = Integer.parseInt(scan.nextLine());
            startMeters+=climbMeters;
            if (startMeters>=everest){
                System.out.printf("Goal reached for %d days!",countDays);
                return;
            }

            input= scan.nextLine();
        }
        System.out.printf("Failed!%n");
        System.out.printf("%d",startMeters);
    }
}
