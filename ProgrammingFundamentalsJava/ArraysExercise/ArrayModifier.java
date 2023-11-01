package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String command = scan.nextLine();

        while (!command.equals("end")) {

            String [] input = command.split(" ");

            if (command.contains("swap")) {
                int index1 = Integer.parseInt(input[1]);
                int index2 = Integer.parseInt(input[2]);

                int firstElement = numbers[index1];
                int secondElement = numbers[index2];

                numbers[index1] = secondElement;
                numbers[index2] = firstElement;

            } else if (command.contains("multiply")) {
                int index1 = Integer.parseInt(input[1]);
                int index2 = Integer.parseInt(input[2]);

                int firstElement = numbers[index1];
                int secondElement = numbers[index2];

                numbers[index1] = firstElement * secondElement;

            } else if (command.contains("decrease")) {

                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }

            command = scan.nextLine();
        }
        System.out.println(Arrays.toString(numbers)
                .replace("[" , "")
                .replace("]" , ""));
    }
}
