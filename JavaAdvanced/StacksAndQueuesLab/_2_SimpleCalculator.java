package JavaAdvanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.in;

public class _2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] input = scan.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack,input);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                     break;
            }
        }
        System.out.println(stack.peek());
    }
}
