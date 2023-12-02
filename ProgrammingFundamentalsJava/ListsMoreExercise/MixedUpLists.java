package ListsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(second);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Math.min(first.size(),second.size()); i++) {
            numbers.add(first.get(i));
            numbers.add(second.get(i));
        }
        int start = 0;
        int end = 0;
        if (first.size() > second.size()) {
            start = first.get(first.size() - 2);
            end = first.get(first.size() - 1);
        } else {
            start = second.get(second.size() - 1);
            end = second.get(second.size() - 2);
        }
        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int digit = numbers.get(i);
            if (start < end) {
                if (digit > start && digit < end) {
                    elements.add(digit);
                }
            } else {
                if (digit < start && digit > end) {
                    elements.add(digit);
                }
            }

        }
        Collections.sort(elements);
        for (int e : elements) {
            System.out.print(e + " ");
        }
    }
}
