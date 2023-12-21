import java.util.Scanner;

import static java.lang.System.in;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int numOfStudents = Integer.parseInt(scan.nextLine());
        int numOfLectures = Integer.parseInt(scan.nextLine());
        int bonus = Integer.parseInt(scan.nextLine());

        double maxBonus = 0;
        int totalAttendances = 0;

        for (int i = 0; i < numOfStudents; i++) {
            int attendances = Integer.parseInt(scan.nextLine());
            double totalBonus = 1.0 *attendances / numOfLectures * (5 + bonus);
            if (totalBonus > maxBonus){
                maxBonus = totalBonus;
                totalAttendances = attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n",Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.",totalAttendances);
    }
}
