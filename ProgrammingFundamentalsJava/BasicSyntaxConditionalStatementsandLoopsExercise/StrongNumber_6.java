package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class StrongNumber_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int sum = 0;


        for (int i = 0; i <String.valueOf(num).length() ; i++) {
            int factorial = 1;
            int number = Integer.parseInt(String.valueOf(String.valueOf(num).charAt(i)));
            for (int j = 1; j <=number ; j++) {
                 factorial*=j;
            }
            sum+=factorial;
        }
        if (sum==num){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}