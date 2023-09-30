package NestedLoopsMoreExercises;

import java.util.Scanner;

public class LuckyNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int lucky = 0;
        int firstDuoSum = 0;
        int secondDuoSum = 0;

        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <=9 ; j++) {
                firstDuoSum=i+j;
                for (int k = 1; k <=9 ; k++) {
                    for (int l = 1; l <=9 ; l++) {
                        secondDuoSum=k+l;
                        if (firstDuoSum==secondDuoSum&&n%firstDuoSum==0){
                            System.out.printf("%d%d%d%d ",i,j,k,l);
                        }
                    }
                }
            }
        }
    }
}
