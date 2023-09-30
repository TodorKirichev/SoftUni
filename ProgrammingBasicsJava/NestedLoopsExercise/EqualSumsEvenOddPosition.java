package NestedLoopsExercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int digit = 0;

        for (int i = start; i <=end ; i++) {
            String num = String.valueOf(i);
            int sumEven = 0;
            int sumOdd = 0;
            for (int j = 0 ; j < num.length(); j++) {
                 digit = Integer.parseInt(String.valueOf(num.charAt(j)));
                if (j%2==0){
                    sumEven+=digit;
                }else {
                    sumOdd+=digit;
                }

            }
            if (sumEven==sumOdd){
                System.out.print(i+ " ");
            }

        }
    }


}
