package JavaAdvanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class _4_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String expression = scan.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                int startIndex = stack.pop();
                String substring = expression.substring(startIndex,i + 1);
                System.out.println(substring);
            }
        }
    }
}
