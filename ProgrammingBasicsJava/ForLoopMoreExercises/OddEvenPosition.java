package ForLoopMoreExercises;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double oddSum = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;
        double evenSum = 0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;

        for (double i = 1; i <=n ; i++) {
            double num = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0) {
                evenSum+=num;
                if (num>evenMax){
                    evenMax=num;
                }else if (num<evenMin){
                    evenMin=num;
                }
            } else {
                oddSum+=num;
                if (num>oddMax){
                    oddMax=num;
                }else if (num<oddMin){
                    oddMin=num;
                }
            }
        }
        System.out.printf("OddSum=%.2f%n",oddSum);
        System.out.printf("OddMin=%.2f%n",oddMin);
        System.out.printf("OddMax=%.2f%n",oddMax);
        System.out.printf("EvenSum=%.2f%n",evenSum);
        System.out.printf("EvenMin=%.2f%n",evenMin);
        System.out.printf("EvenMax=%.2f%n",evenMax);
    }
}
