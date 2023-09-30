package ForLoopMoreExercises;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double inheritance = Double.parseDouble(scan.nextLine());
        int year = Integer.parseInt(scan.nextLine());
        int ivanYears = 18;

        for (int i = 1800; i <= year ; i++) {
            if (i%2==0){
                inheritance-=12000;
            }else {
                inheritance-=(12000+50*ivanYears);
            }
            ivanYears+=1;
        }
        if (inheritance>=0){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",inheritance);
        }else {
            System.out.printf("He will need %.2f dollars to survive.",Math.abs(inheritance));
        }
    }
}
