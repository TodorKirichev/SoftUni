package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class MovieTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a1 = Integer.parseInt(scan.nextLine());
        int a2 = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        int symbol1 = 0;
        int symbol2 = 0;
        int symbol3 = 0;
        int symbol4 = 0;

        for (int i = a1; i < a2; i++) {
            symbol1= i;
            for (int j = 1; j <= n-1; j++) {
                symbol2=j;
                for (int k = 1; k <= n/2-1; k++) {
                    symbol3=k;
                    symbol4=i;
                    if (i%2!=0&&(symbol2+symbol3+symbol4)%2!=0){
                        System.out.printf("%s-%d%d%d%n",(char)symbol1,symbol2,symbol3,symbol4);
                    }
                }
            }
        }
    }
}
