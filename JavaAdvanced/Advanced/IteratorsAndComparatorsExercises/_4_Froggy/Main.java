package Exams.IteratorsAndComparatorsExercises._4_Froggy;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Integer[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Lake lake = new Lake(numbers);
        scan.nextLine();


        StringBuilder sb = new StringBuilder();
        for (Integer i : lake) {
            sb.append(String.valueOf(i)).append(" ");
        }
        System.out.println(String.join(", ", sb.toString().split(" ")));
    }
}
