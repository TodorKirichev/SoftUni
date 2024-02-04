package Exams.EXAMS.JavaAdvancedRetakeExam13December2023;

import java.util.*;

import static java.lang.System.in;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> worms = fillWorms(scan);
        Deque<Integer> holes = fillHoles(scan);

        int wormsInitialCount = worms.size();
        int matches = 0;
        boolean isDead = false;

        while (true) {
            if (worms.isEmpty()) {
                break;
            }
            int worm = worms.peek();

            if (holes.isEmpty()) {
                break;
            }
            int hole = holes.poll();

            if (worm == hole) {
                worms.pop();
                matches++;
            } else {
                int newWorm = worms.pop() - 3;
                if (newWorm > 0) {
                    worms.push(newWorm);
                }
            }
        }
        if (matches > 0) {
            System.out.printf("Matches: %s\n", matches);
        } else {
            System.out.println("There are no matches.");
        }
        if (worms.isEmpty()) {
            if (matches == wormsInitialCount) {
                System.out.println("Every worm found a suitable hole!");
            } else {
                System.out.println("Worms left: none");
            }
        } else {
            List<String> wormsLeft = new ArrayList<>();
            worms.stream().map(String::valueOf).forEach(wormsLeft::add);
            Collections.reverse(wormsLeft);
            System.out.printf("Worms left: %s\n", String.join(", ", wormsLeft));

        }
        if (holes.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            List<String> holesLeft = new ArrayList<>();
            holes.forEach(h -> holesLeft.add(String.valueOf(h)));
            System.out.printf("Holes left: %s\n",String.join(", ", holesLeft));
        }

    }

    private static Deque<Integer> fillHoles(Scanner scan) {
        Deque<Integer> holes = new ArrayDeque<>();
        String[] holesData = scan.nextLine().split("\\s+");
        for (String hole : holesData) {
            holes.offer(Integer.valueOf(hole));
        }
        return holes;
    }

    private static Deque<Integer> fillWorms(Scanner scan) {
        Deque<Integer> worms = new ArrayDeque<>(0);
        String[] wormsData = scan.nextLine().split("\\s+");
        for (String worm : wormsData) {
            worms.push(Integer.valueOf(worm));
        }
        return worms;
    }
}
