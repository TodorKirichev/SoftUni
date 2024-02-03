package JavaAdvanced.StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _7_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder text = new StringBuilder();
        Deque<String> history = new ArrayDeque<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String command = input[0];
            switch (command) {
                case "1":
                    String string = input[1];
                    text.append(string);
                    history.push(text.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    text.replace(text.length() - count,text.length(),"");
                    history.push(text.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    char ch = text.charAt(index - 1);
                    System.out.println(ch);
                    break;
                case "4":
                    history.pop();
                    text = new StringBuilder(history.isEmpty() ? ""  :history.peek());
                    break;

            }
        }
    }
}