package JavaAdvanced.Advanced.BasicAlgorithmsLab;

import java.util.Scanner;

import static java.lang.System.in;

public class _2_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());

        System.out.println(getFactorial(n));
    }

    private static long getFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }
}
