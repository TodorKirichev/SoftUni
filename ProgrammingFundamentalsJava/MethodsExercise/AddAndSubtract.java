package MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        System.out.println(subtract(num1,num2,num3));

    }
    public static int sum(int num1,int num2) {
        return num1 + num2;
    }
    public static int subtract(int num1,int num2,int num3) {
        return sum(num1,num2) - num3;
    }
}
