package JavaAdvanced.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class _6_HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] players = scan.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String player : players) {
            queue.offer(player);
        }
        int n = Integer.parseInt(scan.nextLine());
        int count = 1;
        while (queue.size() > 1) {
            String player = queue.poll();
            if (count == n) {
                System.out.println("Removed " + player);
                count = 0;
            } else {
                queue.offer(player);
            }
            count++;
        }
        System.out.println("Last is " + queue.poll());
    }
}
