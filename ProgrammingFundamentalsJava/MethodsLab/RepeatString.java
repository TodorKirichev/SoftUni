package MethodsLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());

        System.out.println(  printText(text,count));
    }
    public static String printText(String text,int count) {
        String result = "";
        for (int i = 0; i <count ; i++) {
            result += text;
        }
        return result;
    }
}
