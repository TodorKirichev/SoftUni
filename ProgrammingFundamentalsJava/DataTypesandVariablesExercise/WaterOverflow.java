package DataTypesandVariablesExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());
        int capacity = 0;

        for (int i = 0; i < lines; i++) {
            int liter = Integer.parseInt(scan.nextLine());
            if (capacity+liter>255){
                System.out.println("Insufficient capacity!");
            }else {
                capacity+=liter;
            }
        }
        System.out.println(capacity);
    }
}
