package JavaAdvanced.StacksAndQueuesLab;
import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class _5_PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("print")) {
                break;
            }
            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledTask = queue.poll();
                    System.out.println("Canceled " + canceledTask);
                }
            } else {
                queue.offer(input);
            }
        }
       queue.forEach(System.out::println);
    }
}
