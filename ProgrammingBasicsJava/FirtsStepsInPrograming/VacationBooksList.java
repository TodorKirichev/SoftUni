package firtsStepsInPrograming;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pages = Integer.parseInt(scan.nextLine());
        int pagesPerHour = Integer.parseInt(scan.nextLine());
        int numOfDays = Integer.parseInt(scan.nextLine());

        int timePerDay = pages / pagesPerHour / numOfDays;
        System.out.println(timePerDay);
    }
}
