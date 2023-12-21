package ProgrammingFundamentalsFinalExam04;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Done")) {
                break;
            }
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 0; i < password.length() ; i++) {
                        if (i % 2 != 0) {
                            char ch = password.charAt(i);
                            newPassword.append(ch);
                        }
                    }
                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandParts[1]);
                    int length = Integer.parseInt(commandParts[2]);
                    String substring = password.substring(index,index + length);
                    password = password.replaceFirst(substring,"");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring2 = commandParts[1];
                    String substitute = commandParts[2];
                    if (password.contains(substring2)) {
                       password = password.replaceAll(substring2,substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
        }
        System.out.printf("Your password is: %s\n",password);
    }
}
