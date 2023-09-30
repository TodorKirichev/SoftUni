package NestedLoopsMoreExercises;

import java.util.Scanner;

public class CarNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        boolean firstEven = false;
        boolean lastEven = false;

        for (int i = start; i <=end ; i++) {
            if (i%2==0){
                firstEven=true;
            }else {
                firstEven=false;
            }
            for (int j = start; j <=end ; j++) {
                for (int k = start; k <=end ; k++) {
                    for (int l = start; l <=end ; l++) {
                        if (l%2==0){
                            lastEven=true;
                        }else{
                            lastEven=false;
                        }
                        boolean evenOdd = false;
                        if (firstEven&&!lastEven||!firstEven&&lastEven){
                            evenOdd=true;
                        }
                        if (i>l&&(j+k)%2==0&&evenOdd){
                            System.out.printf("%d%d%d%d ",i,j,k,l);
                        }
                    }
                }
            }
        }
    }
}
