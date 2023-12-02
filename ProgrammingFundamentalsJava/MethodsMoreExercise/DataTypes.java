package MethodsMoreExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        String input = scan.nextLine();

        if (type.equals("int")) {
            int value = Integer.parseInt(input);
            System.out.println(checkInput(value));
        } else if (type.equals("real")) {
            double value = Double.parseDouble(input);
            System.out.printf("%.2f",checkInput(value));
        } else {
            System.out.println(checkInput(input));
        }

    }
    public static int checkInput(int value) {
        return value *= 2;
    }
    public static double checkInput(double value) {
        return value *= 1.5;
    }
    public static String checkInput(String input) {
       return input = "$" + input + "$";
    }
}
