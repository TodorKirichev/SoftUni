package NestedLoopsMoreExercises;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int mens = Integer.parseInt(scan.nextLine());
        int womens = Integer.parseInt(scan.nextLine());
        int maxTables = Integer.parseInt(scan.nextLine());
        int menCounter = 1;
        int womenCounter = 1;

        for (int i = 1; i <=mens ; i++) {
            for (int j = 1; j <=womens ; j++) {

                System.out.printf("(%d <-> %d) ",menCounter,womenCounter);
                womenCounter++;
                if ((menCounter+womenCounter)>maxTables){
                    break;
                }
            }
            womenCounter=1;
            menCounter++;
        }
    }
}
