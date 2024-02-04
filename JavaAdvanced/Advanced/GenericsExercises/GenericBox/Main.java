package Exams.GenericsExercises.GenericBox;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            double element = Double.parseDouble(scan.nextLine());
            box.add(element);
        }

        System.out.println(box.greater(Double.valueOf(scan.nextLine())));
    }
}
