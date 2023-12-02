package ListsLab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            double left = numbers.get(i);
            double right = numbers.get(i + 1);
            if (left == right) {
                double newElement = left + right;
                numbers.set(i,newElement);
                numbers.remove(i + 1);
                i = -1;
            }
        }
        for (double e : numbers) {
            System.out.print(new DecimalFormat("0.###").format(e) + " ");
        }
    }
}
