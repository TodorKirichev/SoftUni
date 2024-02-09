package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> tasks = new ArrayDeque<>();
        Deque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(tasks::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(threads::offer);

        int taskToKill = Integer.parseInt(scan.nextLine());
        int killer = 0;

        while (true) {
            int task = tasks.pop();
            int thread = threads.poll();

            if (task == taskToKill) {
                killer = thread;
                threads.addFirst(thread);
                System.out.printf("Thread with value %s killed task %s\n", killer, taskToKill);
                break;
            }
            if (thread < task) {
                tasks.push(task);
            }
        }
        threads.stream().map(String::valueOf).forEach(t -> System.out.print(t + " "));
    }
}
