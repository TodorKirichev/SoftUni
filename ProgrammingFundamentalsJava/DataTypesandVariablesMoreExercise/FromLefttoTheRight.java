package DataTypesandVariablesMoreExercise;
import java.util.Scanner;

public class FromLefttoTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < lines; i++) {

            long sum = 0;

            long left = scan.nextLong();
            long right =scan.nextLong();

            if (left > right) {
                while (left != 0) {
                    long digit = left % 10;
                    sum += digit;
                    left /= 10;
                }
            } else {
                while (right != 0) {
                    long digit = right % 10;
                    sum += digit;
                    right /= 10;
                }
            }
                System.out.println(Math.abs(sum));
        }
    }
}