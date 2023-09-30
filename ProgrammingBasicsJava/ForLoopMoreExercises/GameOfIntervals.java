package ForLoopMoreExercises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int moves = Integer.parseInt(scan.nextLine());
        double points = 0;
        int to10 = 0;
        int to20 = 0;
        int to30 = 0;
        int to40 = 0;
        int to50 = 0;
        int invalidNumber = 0;

        for (int i = 0; i < moves; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (num>=0&&num<10){
                points+=num*0.2;
                to10++;
            }
            else if (num>=10&&num<20){
                points+=num*0.3;
                to20++;
            }
            else if (num>=20&&num<30){
                points+=num*0.4;
                to30++;
            }
            else if (num>=30&&num<40){
                points+=50;
                to40++;
            }
            else if (num>=40&&num<=50){
                points+=100;
                to50++;
            }
            else {
                points/=2;
                invalidNumber++;
            }
        }
        System.out.printf("%.2f%n",points);
        System.out.printf("From 0 to 9: %.2f%%%n",(double)to10/moves*100);
        System.out.printf("From 10 to 19: %.2f%%%n",(double)to20/moves*100);
        System.out.printf("From 20 to 29: %.2f%%%n",(double)to30/moves*100);
        System.out.printf("From 30 to 39: %.2f%%%n",(double)to40/moves*100);
        System.out.printf("From 40 to 50: %.2f%%%n",(double)to50/moves*100);
        System.out.printf("Invalid numbers: %.2f%%%n",(double)invalidNumber/moves*100);
    }
}
