package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam22Feb2020;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> firstBox = new ArrayDeque<>();
        Deque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstBox::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);

        int value = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstLoot = firstBox.poll();
            int secondLoot = secondBox.pop();
            int sum = firstLoot + secondLoot;

            if (sum % 2 == 0) {
                value += sum;
            } else {
                firstBox.addFirst(firstLoot);
                firstBox.offer(secondLoot);
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        if (value < 100) {
            System.out.printf("Your loot was poor... Value: %d\n",value);
        } else {
            System.out.printf("Your loot was epic! Value: %d\n",value);
        }
    }
}
