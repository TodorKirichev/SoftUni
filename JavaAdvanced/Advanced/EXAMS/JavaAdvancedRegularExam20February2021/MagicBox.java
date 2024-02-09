package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> firstBox = new ArrayDeque<>();
        Deque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstBox::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);

        int sumOfItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.poll();
            int second = secondBox.pop();
            int sum = first + second;

            if (sum % 2 == 0) {
                sumOfItems += sum;
            } else {
                firstBox.addFirst(first);
                firstBox.offer(second);
            }
        }
        print(firstBox, secondBox, sumOfItems);
    }

    private static void print(Deque<Integer> firstBox, Deque<Integer> secondBox, int sumOfItems) {
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (sumOfItems < 90) {
            System.out.printf("Poor prey... Value: %d\n", sumOfItems);
        } else {
            System.out.printf("Wow, your prey was epic! Value: %d\n", sumOfItems);
        }
    }
}
