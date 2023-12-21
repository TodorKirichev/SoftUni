package ProgrammingFundamentalsMidExam_2;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List <Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        double average = 1.0 * sum / numbers.size();

        Collections.sort(numbers);
        Collections.reverse(numbers);

        List<Integer> numbersAboveAverage = new ArrayList<>();

        int counter = 0;

        for (int i = 0; i < numbers.size(); i++) {

            if (counter == 5){
                break;
            }
            int digit = numbers.get(i);
            if (digit > average) {
                numbersAboveAverage.add(digit);
            }
            counter++;
        }
        if (numbersAboveAverage.isEmpty()){
            System.out.println("No");
        }
        for (int i : numbersAboveAverage) {
            System.out.print(i + " ");
        }
    }
}
