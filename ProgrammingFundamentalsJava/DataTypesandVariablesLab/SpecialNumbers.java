package DataTypesandVariablesLab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <=n ; i++) {
            int num = i;
            int sum = 0;
            while (num>0){
                int lastDigit = num % 10;
                sum+=lastDigit;
                num=num/10;
            }
            if (sum==5 || sum==7 || sum==11){
                System.out.printf("%d -> True%n",i);
            }else {
                System.out.printf("%d -> False%n",i);
            }
        }
    }
}
