package WhileLoopLab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        double sum = 0;
        int clas = 1;
        int failure = 0;

        while (clas <= 12) {
            double mark = Double.parseDouble(scan.nextLine());
            if (mark < 4) {
                failure++;
                if (failure >= 2) {
                    break;
                }
                continue;
            }




            sum = sum + mark;
            clas++;

        }
        if (failure >= 2) {
            System.out.printf("%s has been excluded at %d grade", name, clas);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", name, sum / 12);
        }
    }
}
