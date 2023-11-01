package ArraysExercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] firstArray = scan.nextLine().split(" ");
        String [] secondArray = scan.nextLine().split(" ");

        for (String secondElement : secondArray) {
            for (String firstElement : firstArray) {
                if (firstElement.equals(secondElement)) {
                    System.out.print(secondElement + " ");
                }
            }
        }
    }
}
