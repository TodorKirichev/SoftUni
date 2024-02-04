package Exams.EXAMS.JavaAdvancedRetakeExam9August2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> monstersArmor = new ArrayDeque<>();
        Deque<Integer> soldierStrikes = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(",")).map(Integer::parseInt).forEach(monstersArmor::offer);
        Arrays.stream(scan.nextLine().split(",")).map(Integer::parseInt).forEach(soldierStrikes::push);

        int monstersKilled = 0;

        while (!monstersArmor.isEmpty() && !soldierStrikes.isEmpty()) {
            int monster = monstersArmor.poll();
            int strike = soldierStrikes.pop();

            if (strike >= monster) {
                monstersKilled++;
                strike -= monster;
                if (strike != 0) {
                    if (soldierStrikes.isEmpty()) {
                        soldierStrikes.push(strike);
                    } else {
                        strike += soldierStrikes.pop();
                        soldierStrikes.push(strike);
                    }
                }
            } else {
                monster -= strike;
                monstersArmor.offer(monster);

            }
        }
        if (monstersArmor.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldierStrikes.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d\n",monstersKilled);
    }
}
