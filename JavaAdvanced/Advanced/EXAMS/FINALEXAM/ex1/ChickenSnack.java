package SoftUni.JavaAdvanced.Advanced.EXAMS.FINALEXAM.ex1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> moneys = new ArrayDeque<>();
        Deque<Integer> prices = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(moneys::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(prices::offer);

        int foods = 0;

        while (!moneys.isEmpty() && !prices.isEmpty()) {
            int money = moneys.pop();
            int price = prices.poll();

            if (money == price) {
                foods++;
            } else if (money > price) {
                foods++;
                if (!moneys.isEmpty() && !prices.isEmpty()) {
                    int nextMoney = moneys.pop();
                    moneys.push(nextMoney + money - price);
                }
            }
        }
        if (foods >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.\n",foods);
        } else if (foods == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else {
            if (foods == 1) {
                System.out.printf("Henry ate: %d food.\n",foods);
            } else {
                System.out.printf("Henry ate: %d foods.\n",foods);
            }
        }
    }
}
