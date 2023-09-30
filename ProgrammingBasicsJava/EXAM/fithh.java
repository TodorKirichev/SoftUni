package EXAM;

import java.util.Scanner;

public class fithh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startHeight = 5364;
        int target = 8848;
        int curentHeight = 0;
        int count = 1;
        while (true) {
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equals("END")) {
                break;
            }
            if (yesOrNo.equals("Yes")) {
                count++;
            }
            int height = Integer.parseInt(scanner.nextLine());
            curentHeight += height;
            if (curentHeight + startHeight >= target) {
                break;
            }
            if (count == 5) {
                break;
            }
        }
        if (startHeight + curentHeight < target) {
            System.out.println("Failed!");
            System.out.printf("%d", startHeight + curentHeight);
        } else {
            System.out.printf("Goal reached for %d days!", count);
        }
    }
}