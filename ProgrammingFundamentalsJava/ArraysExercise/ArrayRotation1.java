package ArraysExercise;

import java.util.Scanner;

public class ArrayRotation1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] array = scan.nextLine().split(" ");
        int rotations = Integer.parseInt(scan.nextLine());

        String [] temp = new String[array.length];

        for (int i = 0; i < rotations; i++) {

            String firstElement = array[0];

            for (int j = 1; j < array.length; j++) {

                temp[j - 1] = array[j];
            }
            temp[temp.length - 1] = firstElement;
            array = temp;
        }
        for (String element : array) {
            System.out.print(element + " ");
        }
    }
}
