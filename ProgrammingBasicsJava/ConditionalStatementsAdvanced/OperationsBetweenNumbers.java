package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N1 = Integer.parseInt(scan.nextLine());
        int N2 = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        double sum = 0;
        String evenOrOdd = "";

        switch (operator){

            case "+":
                sum=N1+N2;
                break;
            case "-":
                sum=N1-N2;
                break;
            case "*":
                sum=N1*N2;
                break;
            case "/":
                if (N2==0){
                    sum = 0;
                }else{
                    sum=(double)N1/N2;
                }
                break;
            case "%":
                if (N2==0){
                    sum = 0;
                }else{
                    sum=N1%N2;
                }
                break;
        }
        if (sum%2==0){
            evenOrOdd="even";
        } else {
            evenOrOdd="odd";
        }

        if (N2==0 && (operator.equals("/") || operator.equals("%"))){
            System.out.printf("Cannot divide %d by zero",N1);

        } else if (operator.equals("+") || operator.equals("-") || operator.equals("*")){
            System.out.printf("%d %s %d = %.0f - %s",N1,operator,N2,sum,evenOrOdd);
        } else if (operator.equals("/")){
            System.out.printf("%d %s %d = %.2f",N1,operator,N2,sum);
        } else if (operator.equals("%")){
            System.out.printf("%d %s %d = %.0f",N1,operator,N2,sum);
        }

    }
}
