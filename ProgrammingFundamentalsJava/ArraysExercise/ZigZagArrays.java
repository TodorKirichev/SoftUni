package ArraysExercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());

        String [] firstArray = new String[lines];
        String [] secondArray = new String[lines];

        for (int i = 0; i < lines; i++) {
            String [] array = scan.nextLine().split(" ");
            String num1 = array[0];
            String num2 = array[1];

            if (i % 2 != 0) {
                firstArray[i] = num2;
                secondArray[i] = num1;
            } else {
                firstArray[i] = num1;
                secondArray[i] = num2;
            }
        }
        for (String i : firstArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (String i : secondArray) {
            System.out.print(i + " ");
        }
    }
}
