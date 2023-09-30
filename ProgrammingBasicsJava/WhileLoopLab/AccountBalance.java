package WhileLoopLab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sum = 0;
        String input = scan.nextLine();
        while (!input.equals("NoMoreMoney")){
            if (Double.parseDouble(input)<0){
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n",Double.parseDouble(input));
            sum += Double.parseDouble(input);
            input = scan.nextLine();



        }
        System.out.printf("Total: %.2f",sum);
    }
}
