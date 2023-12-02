package MethodsMoreExercise;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        System.out.println(checkNum(num1,num2,num3));
    }
    public static String checkNum(int n1,int n2,int n3) {
        String result;
        if (n1 > 0 && n2 > 0 && n3 > 0) {
            result = "positive";
        } else if (n1 == 0 || n2 == 0 || n3 == 0) {
            result = "zero";
        } else {
            int counter = 0;
            if (n1 < 0) {
                counter++;
            }
            if (n2 < 0) {
                counter++;
            }
            if (n3 < 0) {
                counter++;
            }
            if (counter % 2 == 0) {
                result = "positive";
            } else {
                result = "negative";
            }
        }
        return result;
    }
}
