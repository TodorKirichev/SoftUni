package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int  [] wagon = new int [n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scan.nextLine());
            wagon [i] = input;
            sum += input;
        }
        for (int i = 0; i < wagon.length; i++) {
            System.out.print(wagon[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
