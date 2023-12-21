package ProgrammingFundamentalsMidExamRetake_1;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int tourists = Integer.parseInt(scan.nextLine());

        int [] stateOfLift = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < stateOfLift.length; i++) {

            for (int j = stateOfLift[i]; j < 4; j++) {
                if (tourists == 0) {
                    System.out.println("The lift has empty spots!");
                    for (int e : stateOfLift) {
                        System.out.print(e + " ");
                    }
                    return;
                }
                stateOfLift[i] ++;
                tourists--;
            }
        }
        if (tourists > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n",tourists);
            for (int e : stateOfLift) {
                System.out.print(e + " ");
            }
        } else {
            for (int e : stateOfLift) {
                System.out.print(e + " ");
            }
        }
    }
}
