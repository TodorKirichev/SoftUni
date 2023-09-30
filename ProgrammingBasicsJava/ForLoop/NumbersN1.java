package ForLoop;

import java.util.Scanner;

public class NumbersN1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());

        for (int i = a;i>0;i--){
            System.out.println(i);
        }
    }

}
