package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int sum = 0;
            int element = numbers.get(i);

            while (element > 0){
                int digit = element % 10;
                sum += digit;
                element /= 10;
            }
            if (sum > text.size()){
                sum = sum - text.size();
            }
            System.out.print(text.get(sum));
            text.remove(sum);
        }
    }
}
