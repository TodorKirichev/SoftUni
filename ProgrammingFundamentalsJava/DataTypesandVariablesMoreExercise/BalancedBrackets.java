package DataTypesandVariablesMoreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());
        int countOpening = 0;
        int countClosed = 0;
        boolean isBalanced = true;
        int countConsecutive = 0;

        for (int i = 0; i < lines; i++) {
            String text = scan.nextLine();

            switch (text) {
                case "(":
                    countOpening++;
                    countConsecutive = 0;
                    break;
                case ")":
                    countClosed++;
                    countConsecutive++;
                    if (countConsecutive==2){
                        System.out.println("UNBALANCED");
                        return;
                    }
                    break;
            }
            if (Math.abs(countOpening - countClosed) > 1) {
                isBalanced = false;
                break;
            }
        }
        if (countOpening != countClosed || !isBalanced) {
            System.out.println("UNBALANCED");
        }else {
            System.out.println("BALANCED");
        }
    }
}
