package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> lilies = new ArrayDeque<>();
        Deque<Integer> roses = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(lilies::push);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(roses::offer);

        int wreaths = 0;
        int storedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lilie = lilies.pop();
            int rose = roses.poll();
            int sum = lilie + rose;

            if (sum == 15) {
                wreaths++;
            } else if (sum > 15){
                lilies.push(lilie - 2);
                roses.addFirst(rose);
            } else {
                storedFlowers += sum;
            }
        }
        wreaths += storedFlowers / 15;
        if (wreaths < 5) {
            System.out.printf("You didn't make it, you need %d wreaths more!\n",5 - wreaths);
        } else {
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n",wreaths);
        }
    }
}
