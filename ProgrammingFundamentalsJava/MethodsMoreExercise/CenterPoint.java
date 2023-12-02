package MethodsMoreExercise;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());

            checkCoordinate(x1,y1,x2,y2);
    }
    public static void checkCoordinate(int x1,int y1,int x2,int y2) {
        if (x1 + y1 <= x2 + y2) {
            System.out.printf("(%d, %d)",x1,y1);
        } else {
            System.out.printf("(%d, %d)",x2,y2);
        }
    }
}
