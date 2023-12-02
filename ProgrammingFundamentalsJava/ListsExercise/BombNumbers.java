package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scan.nextLine();
        int specialNum = Integer.parseInt(input.split(" ")[0]);
        int power = Integer.parseInt(input.split(" ")[1]);


        while (numbers.contains(specialNum)){
            int indexOfSpecialNum = numbers.indexOf(specialNum);
            int start = Math.max(0,indexOfSpecialNum - power);
            int end = Math.min(numbers.size() - 1,indexOfSpecialNum + power);

            for (int i = start; i <= end; i++) {

                numbers.remove(start);
            }
        }
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        System.out.println(sum);
    }
}
