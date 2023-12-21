package ProgrammingFundamentalsMidExam_2;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scan.nextLine());
        int secondEmployee = Integer.parseInt(scan.nextLine());
        int thirdEmployee = Integer.parseInt(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        int countHours = 0;

        while (students > 0) {
            countHours++;
            if (countHours % 4 == 0) {
                countHours++;
            }
            students = students - firstEmployee - secondEmployee - thirdEmployee;
        }
        System.out.printf("Time needed: %dh.",countHours);
    }
}
