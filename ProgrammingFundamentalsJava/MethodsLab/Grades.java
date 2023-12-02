package MethodsLab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = Double.parseDouble(scan.nextLine());
        gradeInWords(grade);
    }
    public static void gradeInWords (double grade) {
        if (grade >= 2 && grade < 3){
            System.out.printf("Fail");
        } else if (grade >= 3 && grade < 3.5) {
            System.out.printf("Poor");
        }else if (grade >= 3.5 && grade < 4.5) {
            System.out.printf("Good");
        }else if (grade >= 4.5 && grade < 5.5) {
            System.out.printf("Very good");
        }else if (grade >= 5.5 && grade <= 6) {
            System.out.printf("Excellent");
        }
    }
}
