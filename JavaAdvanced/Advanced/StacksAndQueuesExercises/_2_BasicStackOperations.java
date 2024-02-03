package JavaAdvanced.StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class _2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] input = scan.nextLine().split(" ");
        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] numbers = scan.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println(true);
        } else {
            if (stack.isEmpty()) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
