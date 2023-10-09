package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class MultiplicationTable2_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int sum = 0;


        if (m>10){
            System.out.printf("%d X %d = %d",n,m,n*m);
        }else {
            for (int i = m; i <= 10; i++) {
                sum = n * i;
                System.out.printf("%d X %d = %d%n", n, i, sum);
            }
        }
    }
}
