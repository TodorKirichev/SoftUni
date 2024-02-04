package JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam21October2023;

import java.util.*;

import static java.lang.System.in;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> initialFuel = new ArrayDeque<>();
        Deque<Integer> obstacles = new ArrayDeque<>();
        Deque<Integer> fuelNeeded = new ArrayDeque<>();

        String[] firstLine = scan.nextLine().split("\\s+");
        String[] secondLine = scan.nextLine().split("\\s+");
        String[] thirdLine = scan.nextLine().split("\\s+");

        Arrays.stream(firstLine).mapToInt(Integer::parseInt).forEach(initialFuel::push);
        Arrays.stream(secondLine).mapToInt(Integer::parseInt).forEach(obstacles::offer);
        Arrays.stream(thirdLine).mapToInt(Integer::parseInt).forEach(fuelNeeded::offer);

        List<String> reachedAltitudes = new ArrayList<>();

        int initialAltitudesCount = initialFuel.size();

        int counter = 0;

        while (initialFuel.peek() != null && obstacles.peek() != null && fuelNeeded.peek() != null) {
            int fuel = initialFuel.peek();
            int obstacle = obstacles.peek();
            int needed = fuelNeeded.peek();

            if (fuel - obstacle >= needed) {
                initialFuel.pop();
                obstacles.poll();
                fuelNeeded.poll();
                counter++;
                reachedAltitudes.add("Altitude " + counter);
                System.out.printf("John has reached: Altitude %d\n",counter);
            } else {
                System.out.printf("John did not reach: Altitude %d\n",counter + 1);
                break;
            }
        }
        if (fuelNeeded.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            if (counter == 0) {
                System.out.print("John failed to reach the top.\n" +
                        "John didn't reach any altitude.\n");
            } else {
                System.out.printf("John failed to reach the top.\n" +
                        "Reached altitudes: %s\n",String.join(", ",reachedAltitudes));
            }
        }
    }
}








