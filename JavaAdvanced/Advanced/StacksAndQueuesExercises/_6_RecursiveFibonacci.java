package JavaAdvanced.StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class _6_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Long> stack = new ArrayDeque<>();
        long n = Integer.parseInt(scan.nextLine());
        stack.push(0L);
        stack.push(1L);

        for (int i = 0; i < n; i++) {
            long lastNum = stack.pop();
            long firstNum = stack.pop();
            stack.push(lastNum);
            stack.push(lastNum + firstNum);
        }
        System.out.println(stack.pop());
    }
}
