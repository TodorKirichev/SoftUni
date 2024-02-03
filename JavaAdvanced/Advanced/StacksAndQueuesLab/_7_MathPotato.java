package JavaAdvanced.StacksAndQueuesLab;

import java.util.PriorityQueue;
import java.util.Scanner;

import static java.lang.System.in;

public class _7_MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] names = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (String name : names) {
            queue.offer(name);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = queue.poll();
                queue.offer(child);
            }
            boolean isPrime = true;
            if (cycle == 1) {
                isPrime = false;
            } else {
                for (int i = 2; i < cycle; i++) {
                    if (cycle % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }
}
