package ArraysLab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        int day = Integer.parseInt(scan.nextLine());

        if (day > 0 && day <= days.length){
            System.out.println(days[day-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
