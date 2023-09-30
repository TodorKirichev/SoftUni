package NestedLoopsMoreExercises;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        boolean isOne = false;

        for (int i = 1; i <= first; i++) {
            boolean isTwo = false;
            if (i % 2 == 0) {
                isOne = true;
            }
            for (int j = 2; j <= second ; j++) {
                boolean isThree = false;
                int counter=0;
                for (int k = 1; k <= j ; k++) {
                    if (j%k==0){
                        counter++;
                    }
                }
                if (counter<=2){
                    isTwo=true;
                }
                for (int l = 1; l <= third ; l++) {
                    if (l % 2 == 0){
                        isThree=true;
                    }
                    if (isOne&&isTwo&&isThree){
                        System.out.printf("%d %d %d%n",i,j,l);
                    }
                    isThree=false;
                }
                isTwo=false;
            }
            isOne=false;
        }
    }
}
