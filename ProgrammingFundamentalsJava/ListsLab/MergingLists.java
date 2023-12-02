package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] first = scan.nextLine().split(" ");
        String[] second = scan.nextLine().split(" ");

       List<String> numbers = new ArrayList<>();

        if (first.length > second.length) {
            for (int i = 0; i < second.length; i++) {
                String firstE = first[i];
                String secondE = second[i];
                numbers.add(firstE);
                numbers.add(secondE);
            }
            for (int i = second.length; i < first.length; i++) {
                String element = first[i];
                numbers.add(element);
            }
        } else {
            for (int i = 0; i < first.length; i++) {
               String firstE = first[i];
               String secondE = second[i];
                numbers.add(firstE);
                numbers.add(secondE);
            }
            for (int i = first.length ; i < second.length; i++) {
                String element = second[i];
                numbers.add(element);
            }
        }
        for (String e : numbers) {
            System.out.print(e + " ");
        }
    }
}
