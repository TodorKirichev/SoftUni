package JavaAdvanced.StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class _1_ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] input = scan.nextLine().split(" ");
        Deque<String> stack = new ArrayDeque<>();

        for (String s : input) {
            stack.push(s);
        }
            System.out.print(String.join(" ",stack));
    }
}
