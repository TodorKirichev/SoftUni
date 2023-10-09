package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Login_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username = scan.nextLine();
        String password = scan.nextLine();
        String revUsername = "";
        int counter = 1;

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            revUsername=ch + revUsername;
        }
        while (!password.equals(revUsername)) {
            if (counter==4){
                System.out.printf("User %s blocked!",username);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            counter++;
            password=scan.nextLine();
        }
        System.out.printf("User %s logged in.",username);
    }
}
