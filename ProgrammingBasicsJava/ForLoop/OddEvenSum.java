package ForLoop;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sumEven =0;
        int sumOdd=0;

        for (int i =0;i<n;i++){
            int num = Integer.parseInt(scan.nextLine());

            if (i%2==0){
                sumEven+=num;
            }else{
                sumOdd+=num;
            }
        }

        int diff = Math.abs(sumEven-sumOdd);

        if (diff==0){
            System.out.println("Yes");
            System.out.println("Sum = " + sumEven);
        }else{
            System.out.println("No");
            System.out.println("Diff = " + diff);
        }
    }
}
