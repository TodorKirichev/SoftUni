package ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());

        String position = "";


        if ((x>=x1&&x<=x2)&&(y==y1||y==y2)) {
            position = "Border";
        } else if ((y>=y1&&y<=y2)&&(x==x1||x==x2)) {
            position = "Border";
        } else {
            position = "Inside / Outside";
        }
        System.out.println(position);
    }
}
