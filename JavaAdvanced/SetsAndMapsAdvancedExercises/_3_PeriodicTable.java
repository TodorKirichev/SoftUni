package JavaAdvanced.SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            for (String s : input) {
                elements.add(s);
            }
        }
        System.out.println(String.join(" ", elements));
    }
}
