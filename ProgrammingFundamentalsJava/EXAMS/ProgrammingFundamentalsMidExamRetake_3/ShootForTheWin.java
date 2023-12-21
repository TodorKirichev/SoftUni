package ProgrammingFundamentalsMidExamRetake_3;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String command = scan.nextLine();
        int countShotTargets = 0;

        while (!command.equals("End")) {

            int index = Integer.parseInt(command);
            if (index > numbers.length - 1){
                command = scan.nextLine();
                continue;
            }
            if (numbers[index] == -1){
                command = scan.nextLine();
                continue;
            } else {
                countShotTargets++;
                int shotTarget = numbers[index];
                numbers[index] = -1;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] > shotTarget && numbers[i] != -1) {
                        numbers[i] -= shotTarget;
                    }else if (numbers[i] <= shotTarget && numbers[i] != -1){
                        numbers[i] += shotTarget;
                    }
                }
            }

            command = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",countShotTargets);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
