package EXAM;

import java.util.Scanner;

public class Sixth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       StringBuilder reverseNum = new StringBuilder(scan.nextLine());
       StringBuilder num = reverseNum.reverse();

        for (int i = 1; i <=Integer.parseInt(String.valueOf(num.charAt(0))) ; i++) {
            for (int j = 1; j <=Integer.parseInt(String.valueOf(num.charAt(1))) ; j++) {
                for (int k = 1; k <=Integer.parseInt(String.valueOf(num.charAt(2))) ; k++) {
                    System.out.printf("%d * %d * %d = %d;%n",i,j,k,i*j*k);
                }
            }
        }
    }
}
