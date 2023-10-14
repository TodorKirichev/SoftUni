package DataTypesandVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int yield = Integer.parseInt(scan.nextLine());
        int daysCount = 0;
        int totalSpice = 0;

        while (yield>=100){

            totalSpice+=yield-26;

            daysCount++;
            yield-=10;
        }
        if (totalSpice >= 26) {
            totalSpice -= 26;
        }
        System.out.println(daysCount);
        System.out.println(totalSpice);
    }
}
