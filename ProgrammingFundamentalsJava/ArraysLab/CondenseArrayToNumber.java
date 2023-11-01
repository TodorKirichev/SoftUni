package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();

        int [] temp = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            temp[i] = numbers[i];
        }
        for (int i = 0; i < numbers.length-1; i++) {
            int [] condensed = new int[temp.length-1];

            for (int j = 0; j <= condensed.length - 1; j++) {
                condensed[j]=temp[j]+temp[j+1];
            }
            temp=condensed;
        }
        System.out.println(temp[0]);
    }
}
