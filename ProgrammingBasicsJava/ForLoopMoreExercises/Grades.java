package ForLoopMoreExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int students = Integer.parseInt(scan.nextLine());
        int top = 0;
        int veryGood = 0;
        int good = 0;
        int fail = 0;
        double midMark = 0;

        for (int i = 0; i < students; i++) {
            double mark = Double.parseDouble(scan.nextLine());
            midMark+=mark;
            if (mark>=5){
                top++;
            }
            else if (mark>=4){
                veryGood++;
            }
            else if (mark>=3){
                good++;
            }
            else if (mark>=2){
                fail++;
            }
        }
        System.out.printf("Top students: %.2f%%%n",(double)top/students*100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n",(double)veryGood/students*100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n",(double)good/students*100);
        System.out.printf("Fail: %.2f%%%n",(double)fail/students*100);
        System.out.printf("Average: %.2f",midMark/students);
    }
}
