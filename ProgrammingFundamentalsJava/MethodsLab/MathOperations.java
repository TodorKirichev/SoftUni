package MethodsLab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {

        System.out.println(calculate());
    }
    public static int calculate() {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        int number2 = Integer.parseInt(scan.nextLine());

        int result = 0;

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        return result;
    }
}
