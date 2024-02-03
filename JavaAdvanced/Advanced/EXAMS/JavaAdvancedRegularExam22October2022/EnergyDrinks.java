package Advanced.EXAMS.JavaAdvancedRegularExam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> milligramsOfCaffeine = new ArrayDeque<>();
        Deque<Integer> energyDrinks = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(milligramsOfCaffeine::push);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(energyDrinks::offer);

        int StamatCaffeine = 0;

        while (!milligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int caffeine = milligramsOfCaffeine.pop();
            int drink = energyDrinks.poll();
            int result = caffeine * drink;

            if (result + StamatCaffeine <= 300) {
             StamatCaffeine += result;
            } else {
                energyDrinks.offer(drink);
                StamatCaffeine -= 30;
                if (StamatCaffeine < 0) {
                    StamatCaffeine = 0;
                }
            }
        }
        if (energyDrinks.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            StringBuilder sb = new StringBuilder();
            energyDrinks.forEach(d -> sb.append(String.valueOf(d)).append(" "));
            System.out.printf("Drinks left: %s\n",String.join(", ",sb.toString().split(" ")));
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.\n",StamatCaffeine);
    }
}
