package DataTypesandVariablesLab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            if (sum==5 || sum==7 || sum==11){
                System.out.printf("%d -> True%n",number);
            }else {
                System.out.printf("%d -> False%n",number);
            }
            sum = 0;
            i = number;
        }


    }
}
