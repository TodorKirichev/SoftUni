package Exams.EXAMS.JavaAdvancedRetakeExam12April2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> programmersTime = new ArrayDeque<>();
        Deque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(programmersTime::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(tasks::push);

        int darthVaderDucky = 0;
        int thorDucky = 0;
        int bigBlueRubberDucky = 0;
        int smallYellowRubberDucky = 0;

        while (!programmersTime.isEmpty() && !tasks.isEmpty()) {
            int time = programmersTime.poll();
            int task = tasks.pop();
            int result = time * task;

            if (result >= 0 && result <= 60) {
                darthVaderDucky++;
            } else if (result <= 120) {
                thorDucky++;
            } else if (result <= 180) {
                bigBlueRubberDucky++;
            } else if (result <= 240) {
                smallYellowRubberDucky++;
            } else {
                tasks.push(task - 2);
                programmersTime.offer(time);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d\n" +
                "Thor Ducky: %d\n" +
                "Big Blue Rubber Ducky: %d\n" +
                "Small Yellow Rubber Ducky: %d\n",darthVaderDucky,thorDucky,bigBlueRubberDucky,smallYellowRubberDucky);
    }
}
