package JavaAdvanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class _1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String currentPage = null;
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Home")) {
                break;
            }
            if (input.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    currentPage = history.pop();
                }
            } else {
                if (currentPage != null) {
                    history.push(currentPage);
                }
                currentPage = input;
            }
            System.out.println(currentPage);
        }
    }
}
