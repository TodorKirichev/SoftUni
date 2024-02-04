package Exams.EXAMS.JavaAdvancedRetakeExam18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class KAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> licensePlates = new ArrayDeque<>();
        Deque<Integer> numOfCars = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(licensePlates::offer);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(numOfCars::push);

        int days = 0;
        int registeredCars = 0;

        while (!licensePlates.isEmpty() && !numOfCars.isEmpty()) {
            int plates = licensePlates.poll();
            int cars = numOfCars.pop();

            int possibleRegisteredCars = plates / 2;
            if (cars <= possibleRegisteredCars) {
                registeredCars += cars;
                int platesLeft = plates - cars * 2;
                if (platesLeft > 0) {
                    licensePlates.offer(platesLeft);
                }
            } else {
                registeredCars += possibleRegisteredCars;
                numOfCars.addLast(cars - possibleRegisteredCars);
            }
            days++;
        }
        System.out.printf("%d cars were registered for %d days!\n",registeredCars,days);
        if (licensePlates.isEmpty() && numOfCars.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else {
            if (!licensePlates.isEmpty()) {
                System.out.printf("%d license plates remain!\n",sumPlates(licensePlates));
            }
            if (!numOfCars.isEmpty()) {
                System.out.printf("%d cars remain without license plates!\n",sumCars(numOfCars));
            }
        }
    }

    private static int sumCars(Deque<Integer> numOfCars) {
        int sum = 0;
        for (Integer car : numOfCars) {
            sum += car;
        }
        return sum;
    }

    private static int sumPlates(Deque<Integer> licensePlates) {
        int sum = 0;
        for (Integer plate : licensePlates) {
            sum += plate;
        }
        return sum;
    }
}
