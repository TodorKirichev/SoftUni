package NestedLoopsLab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magicNumber = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int counter = 0;

        for (int first = start; first <=end ; first++) {
            for (int second = start; second <=end ; second++) {
                counter++;
                sum = first+second;
                if (sum==magicNumber){
                    System.out.printf("Combination N:%d (%d + %d = %d)",counter,first,second,magicNumber);
                    break;
                }
            }
            if (sum==magicNumber){
                break;
            }
        }
        if (sum!=magicNumber){
            System.out.printf("%d combinations - neither equals %d",counter,magicNumber);
        }
    }
}
