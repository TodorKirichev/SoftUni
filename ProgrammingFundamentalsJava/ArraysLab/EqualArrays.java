package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] first = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int [] second = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sum = 0;
        boolean isIdentical = true;

        for (int i = 0; i < first.length; i++) {
            int number1 = first[i];
            int number2 = second[i];

            if (number1==number2){
                sum+=number1;
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                isIdentical=false;
                break;
            }
        }
        if (isIdentical){
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
