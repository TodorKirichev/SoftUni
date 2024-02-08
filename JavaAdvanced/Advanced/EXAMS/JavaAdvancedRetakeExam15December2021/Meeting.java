package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class Meeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> males = new ArrayDeque<>();
        Deque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        int matchesCount = 0;



        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();

            if (male <= 0) {
                males.pop();
                continue;
            }
            if (female <= 0) {
                females.poll();
                continue;
            }
            if (male % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (female % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }
            if (male == female) {
                males.pop();
                females.poll();
                matchesCount++;
            } else {
                females.poll();
                males.push(males.pop() - 2);
            }

        }
        System.out.printf("Matches: %d\n",matchesCount);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            males.forEach(m -> sb.append(m).append(" "));
            System.out.printf("Males left: %s\n",String.join(", ",sb.toString().split(" ")));
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            females.forEach(f -> sb.append(f).append(" "));
            System.out.printf("Females left: %s\n",String.join(", ",sb.toString().split(" ")));
        }
    }
}
