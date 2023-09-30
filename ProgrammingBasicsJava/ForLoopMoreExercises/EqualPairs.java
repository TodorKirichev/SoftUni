package ForLoopMoreExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pairs = Integer.parseInt(scan.nextLine());
        int sumMin = Integer.MAX_VALUE;
        int sumMax =Integer.MIN_VALUE;
        int counter = 0;
        int maxDiff = 0;
        int diff=0;

        for (int i = 0; i < pairs; i++) {
            int num1 = Integer.parseInt(scan.nextLine());
            int num2 = Integer.parseInt(scan.nextLine());
            int sum = num1+num2;

            if (sum>sumMax){
                sumMax=sum;
            }else if (sum<sumMin){
                sumMin=sum;
            }
            counter++;
            if (counter==4){
                diff=Math.abs(sumMax-sumMin);
                    counter=2;
                    if (diff>maxDiff){
                        maxDiff=diff;
                    }
            }
        }
        if (sumMin==sumMax){
            System.out.printf("Yes, value=%d",sumMin);
        }else{
            System.out.printf("No, maxdiff=%d",maxDiff);
        }
    }
}
