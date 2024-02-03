package JavaAdvanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class _8_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(in);

        ArrayDeque<String> backwardHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        String currentPage = null;
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Home")) {
                break;
            }
            if (input.equals("back")) {
                if (backwardHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    forwardHistory.push(currentPage);
                    currentPage = backwardHistory.pop();
                }
            } else if (input.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                    continue;
                } else {
                    currentPage = forwardHistory.pop();
                }
            } else {
                if (currentPage != null) {
                    backwardHistory.push(currentPage);
                    forwardHistory.clear();
                }
                currentPage = input;
            }
            System.out.println(currentPage);
        }
    }
}
