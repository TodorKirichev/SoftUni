package ForLoopMoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int months = Integer.parseInt(scan.nextLine());
        double electricity = 0;
        double water = 0;
        double internet = 0;
        double others = 0;

        for (int i = 0; i < months; i++) {
            double n = Double.parseDouble(scan.nextLine());
            electricity += n;
            water+=20;
            internet+=15;
            others=(electricity+water+internet)*1.2;

        }
        double average = (electricity+water+internet+others)/months;
        System.out.printf("Electricity: %.2f lv%n",electricity);
        System.out.printf("Water: %.2f lv%n",water);
        System.out.printf("Internet: %.2f lv%n",internet);
        System.out.printf("Other: %.2f lv%n",others);
        System.out.printf("Average: %.2f lv%n",average);
    }
}
