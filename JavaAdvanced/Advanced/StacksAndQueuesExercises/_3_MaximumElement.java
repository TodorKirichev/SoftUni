package JavaAdvanced.StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class _3_MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = scan.nextLine().split(" ");
            String command = commandParts[0];
            if (command.equals("1")) {
                int number = Integer.parseInt(commandParts[1]);
                stack.push(number);
            } else if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
