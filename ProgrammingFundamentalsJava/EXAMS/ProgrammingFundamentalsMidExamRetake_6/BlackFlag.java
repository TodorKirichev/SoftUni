package ProgrammingFundamentalsMidExamRetake_6;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int plunderPerDay = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());
        double plunder = 0;

        for (int i = 1; i <= days; i++) {
            plunder +=plunderPerDay;
            if (i % 3 == 0){
                plunder += plunderPerDay * 0.5;
            }
            if (i % 5 == 0){
                plunder -= plunder * 0.3;
            }
        }
        if (plunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n",plunder);
        } else {
            double percentage = plunder / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.",percentage);
        }
    }
}
