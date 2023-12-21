package ProgrammingFundamentalsMidExam_2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String command = scan.next();

        while (!command.equals("end")){

            switch (command){
                case "swap":
                    int firstIndex = scan.nextInt();
                    int secondIndex = scan.nextInt();
                    int firstElement = numbers[firstIndex];
                    int secondElement = numbers[secondIndex];
                    numbers[firstIndex] = secondElement;
                    numbers[secondIndex] = firstElement;
                    break;
                case "multiply":
                    int first = scan.nextInt();
                    int second = scan.nextInt();
                    int sum = numbers[first] * numbers[second];
                    numbers[first] = sum;
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] -= 1;
                    }
                    break;
            }

            command = scan.next();
        }
            System.out.print(String.join(", ",Arrays.toString(numbers))
                    .replace("[","")
                    .replace("]",""));
    }
}
// for (int i = 0; i < numbers.length; i++) {
//                        numbers[i] -= 1;
//                    }