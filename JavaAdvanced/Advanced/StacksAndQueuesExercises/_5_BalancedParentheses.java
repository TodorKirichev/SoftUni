package JavaAdvanced.StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class _5_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String input = scan.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> queue = new ArrayDeque<>();

        boolean isBalanced = true;
        if (input.length() % 2 != 0) {
            isBalanced = false;
        } else {
            for (int i = 0; i < input.length(); i++) {
                char bracket = input.charAt(i);
                if (bracket == '(' || bracket == '[' || bracket == '{') {
                    stack.push(bracket);
                } else {
                    char lastOpening = stack.pop();
                    if (lastOpening == '(' && bracket != ')') {
                        isBalanced = false;
                    } else if (lastOpening == '[' && bracket != ']') {
                        isBalanced = false;
                    } else if (lastOpening == '{' && bracket != '}') {
                        isBalanced = false;
                    }
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
