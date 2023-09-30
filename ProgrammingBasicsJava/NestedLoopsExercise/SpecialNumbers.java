package NestedLoopsExercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int counter = 0;

        for (int i = 1111; i <=9999 ; i++) {
            String text = String.valueOf(i);
            for (int j = 0; j < text.length(); j++) {
                int devider = Integer.parseInt(String.valueOf(text.charAt(j)));
                if (devider==0){
                    continue;
                }
                if (number % devider==0){
                    counter ++;
                }
            }
            if (counter>=text.length()){
                System.out.printf("%d ",i);
            }
            counter=0;
        }
    }
}
