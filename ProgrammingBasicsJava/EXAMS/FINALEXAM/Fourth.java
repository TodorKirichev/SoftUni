package EXAM;

import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numStudents = Integer.parseInt(scan.nextLine());
        int top = 0;
        int good = 0;
        int mid = 0;
        int fail = 0;
        double sumMarks = 0;

        for (int i = 0; i < numStudents; i++) {

            double mark = Double.parseDouble(scan.nextLine());
            sumMarks+=mark;

            if (mark<3){
                fail++;
            } else if (mark<4) {
                mid++;
            } else if (mark<5) {
                good++;
            } else {
                top++;
            }
        }
        System.out.printf("Top students: %.2f%%%n",(double)top/numStudents*100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n",(double)good/numStudents*100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n",(double)mid/numStudents*100);
        System.out.printf("Fail: %.2f%%%n",(double)fail/numStudents*100);
        System.out.printf("Average: %.2f",sumMarks/numStudents);
    }
}
