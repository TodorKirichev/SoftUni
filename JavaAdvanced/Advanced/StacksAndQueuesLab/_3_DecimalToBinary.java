package JavaAdvanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class _3_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int number = Integer.parseInt(scan.nextLine());

        if (number > 0) {
            while (number > 0) {
                int leftOver = number % 2;
                stack.push(leftOver);
                number /= 2;
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        } else {
            System.out.println(0);
        }
    }
}
