package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionLab._2_PoinInRectangle;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Rectangle rectangle = createRectangle(scan.nextLine());

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] currentPointCoordinates = scan.nextLine().split("\\s+");
            int x = Integer.parseInt(currentPointCoordinates[0]);
            int y = Integer.parseInt(currentPointCoordinates[1]);
            Point point = new Point(x,y);

            System.out.println(rectangle.contains(point));
        }
    }

    private static Rectangle createRectangle(String line) {
        String[] coordinates = line.split("\\s+");
        Point bottomLeft = new Point(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
        Point topRight = new Point(Integer.parseInt(coordinates[2]),Integer.parseInt(coordinates[3]));
        return new Rectangle(bottomLeft,topRight);
    }
}
