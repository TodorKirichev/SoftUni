package MethodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

       switch (input) {
           case "int":
              int firstNum = Integer.parseInt(scan.nextLine());
              int secondNum = Integer.parseInt(scan.nextLine());
               System.out.println(getMax(firstNum,secondNum));
               break;
           case "char":
               char firstChar = scan.next().charAt(0);
               char secondChar = scan.next().charAt(0);
               System.out.println(getMax(firstChar,secondChar));
               break;
           case "string":
               String firstString = scan.nextLine();
               String secondString = scan.nextLine();
               System.out.println(getMax(firstString,secondString));
               break;
       }
    }
    public static int getMax(int first,int second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }
    public static char getMax(char first,char second){
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }
    public static String getMax(String first,String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }
}
