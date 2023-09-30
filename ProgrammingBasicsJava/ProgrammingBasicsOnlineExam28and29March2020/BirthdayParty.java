package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double rent = Double.parseDouble(scan.nextLine());

        double cake = rent*0.2;
        double drinks = cake*0.55;
        double animator = rent/3;

        double sum = rent+cake+drinks+animator;
        System.out.println(sum);
    }
}
