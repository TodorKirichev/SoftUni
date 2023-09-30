package ForLoopMoreExercises;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pairs = Integer.parseInt(scan.nextLine());
        int sumMin = Integer.MAX_VALUE;
        int sumMax = 0;
        int diff = 0;
        int counter = 0;
        boolean isOne = true;

        for (int i = 0; i < pairs; i++) {
            int num1 = Integer.parseInt(scan.nextLine());
            int num2 = Integer.parseInt(scan.nextLine());
            int sum = num1 + num2;



           if (sum<sumMin) {
               sumMin=sum;
           } else {
               sumMax=sum;
           }

           diff=Math.abs(sumMax-sumMin);
           if (sumMax-sumMin>diff){
               diff=sumMax-sumMin;
           }
           counter++;
           if (counter==1&&pairs==1){
               isOne=false;
               System.out.printf("Yes, value=%d",sum);
           }

        }
        if (sumMin==sumMax){
            System.out.printf("Yes, value=%d",sumMin);
        }else if (isOne){
            System.out.printf("No, maxdiff=%d", diff);
        }
    }
}
