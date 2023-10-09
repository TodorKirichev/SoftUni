package BasicSyntaxConditionalStatementsandLoopsMoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double balance = budget;
        String command = scan.nextLine();

        while (!"Game Time".equals(command)){
            double price = 0;
            switch (command){
                case "OutFall 4":
                    price=39.99;
                    break;
                case "CS: OG":
                    price=15.99;
                    break;
                case "Zplinter Zell":
                    price=19.99;
                    break;
                case "Honored 2":
                    price=59.99;
                    break;
                case "RoverWatch":
                    price=29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price=39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    command= scan.nextLine();
                    continue;

            }
            budget-=price;

            if (budget>=0){
                    System.out.printf("Bought %s%n",command);
            }else if (budget<0){
            System.out.println("Too Expensive");
            budget+=price;
            }
            if (budget==0){
                System.out.println("Out of money!");
                return;
            }
            command= scan.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f",balance-budget,budget);
    }
}
