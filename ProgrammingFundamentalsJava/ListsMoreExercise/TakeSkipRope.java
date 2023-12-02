package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        StringBuilder nonNumbers = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                numbers.add(Integer.parseInt(String.valueOf(ch)));
            } else {
                nonNumbers.append(ch);
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skiplist = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skiplist.add(numbers.get(i));
            }
        }
        int index = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < takeList.size(); i++) {
            String substring = nonNumbers.substring(index,index + takeList.get(i));
            result.append(substring);
            index += takeList.get(i) + skiplist.get(i);
        }
        System.out.println(result);
    }
}
