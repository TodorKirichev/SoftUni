package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> drumSet = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> initialQuality = new ArrayList<>(drumSet);
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Hit it again, Gabsy!")) {
                break;
            }
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSet.size(); i++) {
                int quality = initialQuality.get(i);
                drumSet.set(i,drumSet.get(i) - hitPower);
                if (drumSet.get(i) <= 0) {
                    if (savings > quality * 3) {
                        savings -= quality * 3;
                        drumSet.set(i,quality);
                    } else {
                        drumSet.remove(i);
                        initialQuality.remove(i);
                        i--;
                    }
                }
            }
        }
        for (int drum : drumSet) {
            System.out.print(drum + " ");
        }
        System.out.printf("\nGabsy has %.2flv.\n",savings);
    }
}
