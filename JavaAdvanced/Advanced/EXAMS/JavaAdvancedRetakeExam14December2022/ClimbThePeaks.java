package Exams.EXAMS.JavaAdvancedRetakeExam14December2022;

import java.util.*;

import static java.lang.System.in;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int conqueredPeaks = 0;
        Deque<Integer> dailyPortion = new ArrayDeque<>();
        Deque<Integer> dailyStamina = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(dailyPortion::push);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(dailyStamina::offer);

        List<String> peaks = new ArrayList<>();
        peaks.add("Vihren");
        peaks.add("Kutelo");
        peaks.add("Banski Suhodol");
        peaks.add("Polezhan");
        peaks.add("Kamenitza");
        Deque<Integer> heights = new ArrayDeque<>();
        heights.push(70);
        heights.push(60);
        heights.push(100);
        heights.push(90);
        heights.push(80);

        int days = 7;
        while (days-- > 0 && !dailyPortion.isEmpty() && !dailyStamina.isEmpty()) {
            int portion = dailyPortion.pop();
            int stamina = dailyStamina.poll();
            int result = portion + stamina;

            if (result >= heights.peek()) {
                heights.pop();
                conqueredPeaks++;
            }
            if (conqueredPeaks == 5) {
                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
                break;
            }
        }
        if (conqueredPeaks < 5) {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (conqueredPeaks > 0) {
            System.out.println("Conquered peaks:");
            for (int i = 0; i < conqueredPeaks; i++) {
                System.out.println(peaks.get(i));
            }
        }
    }
}
