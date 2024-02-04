package JavaAdvanced.Advanced.BasicAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class _1_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index = 0;
        System.out.println(getSum(arr,index));
    }
    public static int getSum(int[] arr,int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return arr[index] + getSum(arr, index + 1);
    }
}
