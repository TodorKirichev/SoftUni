package MethodsExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        printSmallest(num1,num2,num3);
    }
    public static void printSmallest(int num1,int num2,int num3) {
        System.out.println(Math.min(Math.min(num1,num2),num3));
    }
}
