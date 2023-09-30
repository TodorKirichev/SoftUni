package NestedLoopsExercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int judges = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        double sumMarks = 0;
        int numPresentations = 0;

        while (!input.equals("Finish")){

            String presentationName = input;
            double finalMark = 0;

            for (int i = 0; i < judges; i++) {
                double mark = Double.parseDouble(scan.nextLine());
                finalMark+=mark;
                numPresentations++;
            }
            sumMarks+=finalMark;
            System.out.printf("%s - %.2f.%n",presentationName,finalMark/judges);

            input= scan.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.",sumMarks/numPresentations);
    }
}
