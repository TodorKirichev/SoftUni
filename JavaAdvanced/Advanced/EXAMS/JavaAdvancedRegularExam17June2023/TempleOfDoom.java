package Exams.EXAMS.JavaAdvancedRegularExam17June2023;

import java.util.*;

import static java.lang.System.in;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> tools = new ArrayDeque<>();
        Deque<Integer> substances = new ArrayDeque<>();
        List<Integer> challenges = new ArrayList<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(tools::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(substances::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(challenges::add);

        while (!tools.isEmpty() && !substances.isEmpty()) {
            int tool = tools.peek();
            int substance = substances.peek();

            if (challenges.contains(tool * substance)) {
                tools.poll();
                substances.pop();
                challenges.remove(challenges.indexOf(tool * substance));
            } else {
                tools.offer(tools.poll() + 1);
                substances.push(substances.pop() - 1);
                if (substances.peek() != null && substances.peek() == 0) {
                    substances.pop();
                }
            }
        }
        if (substances.isEmpty() && !challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else if (challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }
        if (!tools.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            tools.forEach(t -> sb.append(t).append(" "));
            System.out.printf("Tools: %s\n",String.join(", ",sb.toString().split("\\s+")).trim());
        }
        if (!substances.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            substances.forEach(t -> sb.append(t).append(" "));
            System.out.printf("Substances: %s\n",String.join(", ",sb.toString().split("\\s+")).trim());
        }
        if (!challenges.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            challenges.forEach(t -> sb.append(t).append(" "));
            System.out.printf("Challenges: %s\n",String.join(", ",sb.toString().split("\\s+")).trim());
        }
    }
}
