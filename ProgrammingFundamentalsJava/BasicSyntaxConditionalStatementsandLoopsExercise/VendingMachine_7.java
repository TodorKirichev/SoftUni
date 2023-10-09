package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class VendingMachine_7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        double total = 0;

        while (!"Start".equals(command)){
            switch (command){
                case "0.1":
                case "0.2":
                case "0.5":
                case "1":
                case "2":
                    double coin = Double.parseDouble(command);
                    total+=coin;
                    break;
                default:
                    System.out.printf("Cannot accept %.2f%n",Double.parseDouble(command));
                    break;
            }
            command=scan.nextLine();
        }
        String command2 = scan.nextLine();

        while (!"End".equals(command2)){
            switch (command2){
                case "Nuts":
                    if (total-2.0<0){
                        System.out.println("Sorry, not enough money");
                    }else {
                        System.out.printf("Purchased %s%n",command2);
                        total-=2.0;
                    }
                    break;
                case "Coke":
                    if (total-1.0<0){
                        System.out.println("Sorry, not enough money");
                    }else {
                        System.out.printf("Purchased %s%n",command2);
                        total-=1.0;
                    }
                    break;
                case "Water":
                    if (total-0.7<0){
                        System.out.println("Sorry, not enough money");
                    }else {
                        System.out.printf("Purchased %s%n",command2);
                        total-=0.7;
                    }
                    break;
                case "Crisps":
                    if (total-1.5<0){
                        System.out.println("Sorry, not enough money");
                    }else {
                        System.out.printf("Purchased %s%n",command2);
                        total-=1.5;
                    }
                    break;
                case "Soda":
                    if (total-0.8<0){
                        System.out.println("Sorry, not enough money");
                    }else {
                        System.out.printf("Purchased %s%n",command2);
                        total-=0.8;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }

            command2= scan.nextLine();
        }
        System.out.printf("Change: %.2f",total);
    }
}
