package JavaAdvanced.SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            first.add(Integer.valueOf(scan.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            second.add(Integer.valueOf(scan.nextLine()));
        }
        first.retainAll(second);
        first.forEach(integer -> System.out.print(integer + " "));
    }
}
