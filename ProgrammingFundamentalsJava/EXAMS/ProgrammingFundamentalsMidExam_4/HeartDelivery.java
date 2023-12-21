package ProgrammingFundamentalsMidExam_4;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] neighborhood = Arrays.stream(scan.nextLine().split("@"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String command = scan.nextLine();
        int lastPosition = 0;
        int cupidPosition = 0;

        while (!command.equals("Love!")){

            int jumpIndex = Integer.parseInt(command.split(" ")[1]);

            if (jumpIndex + cupidPosition > neighborhood.length - 1){
                jumpIndex = 0;
                cupidPosition = 0;

            }

            if (neighborhood[jumpIndex + cupidPosition] == 0){
                System.out.printf("Place %d already had Valentine's day.%n",jumpIndex + cupidPosition);
            } else {
                neighborhood[jumpIndex + cupidPosition] -= 2;
                if (neighborhood[jumpIndex + cupidPosition] == 0 ){
                    System.out.printf("Place %d has Valentine's day.%n",jumpIndex + cupidPosition);
                }
            }
            lastPosition = jumpIndex + cupidPosition;
            cupidPosition = lastPosition;
            command = scan.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n",lastPosition);

        int sum = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            sum += neighborhood[i];
        }
        if (sum == 0){
            System.out.println("Mission was successful.");
        } else {
            int houseCount = 0;
            for (int i = 0; i < neighborhood.length; i++) {
                if (neighborhood[i] > 0){
                    houseCount++;
                }
            }
            System.out.printf("Cupid has failed %d places.",houseCount);
        }
    }
}
