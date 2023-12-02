package ListsMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] track = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int finish = track.length / 2;
        double firstTime = 0;
        double secondTime = 0;

        for (int i = 0; i < finish; i++) {
            firstTime += track[i];
            if (track[i] == 0) {
                firstTime *= 0.8;
            }
        }
        for (int i = track.length - 1; i > finish; i--) {
            secondTime += track[i];
            if (track[i] == 0) {
                secondTime *= 0.8;
            }
        }
        if (firstTime < secondTime){
            System.out.printf("The winner is left with total time: %.1f%n",firstTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f%n",secondTime);
        }
    }
}
