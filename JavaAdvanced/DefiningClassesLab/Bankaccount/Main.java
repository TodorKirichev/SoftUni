package JavaAdvanced.DefiningClassesLab.Bankaccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Map<Integer,BankAccount> bankAccounts = new HashMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("End")) {
                break;
            }
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created\n",bankAccount.getId());
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(commandParts[1]);
                double amount = Double.parseDouble(commandParts[2]);
                if (bankAccounts.containsKey(id)) {
                    bankAccounts.get(id).deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d\n",amount,id);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(commandParts[1]);
                BankAccount.setInterestRate(interest);
            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(commandParts[1]);
                int years = Integer.parseInt(commandParts[2]);
                if (bankAccounts.containsKey(id)) {
                    System.out.printf("%.2f\n",bankAccounts.get(id).getInterest(years));
                } else {
                    System.out.println("Account does not exist");
                }
            }
        }
    }
}
