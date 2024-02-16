package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Deque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.poll();
            int female = females.poll();

            if (male == 0 || female == 0) {
                if (male == 0) {
                    females.addFirst(female);
                }
                if (female == 0) {
                    males.push(male);
                }
            } else if (male % 25 == 0 || female % 25 == 0){
                if (male % 25 == 0) {
                    males.pop();
                    females.addFirst(female);
                }
                if (female % 25 == 0) {
                    females.poll();
                    males.push(male);
                }
            } else if (male == female) {
                matches++;
            } else {
                if (male - 2 > 0) {
                    males.push(male - 2);
                }
            }
        }
        System.out.printf("Matches: %d\n",matches);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.printf("Males left: %s\n"
                    ,males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.printf("Females left: %s\n"
            ,females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
