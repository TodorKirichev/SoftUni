package ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class Oscarsceremony {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rent = Integer.parseInt(scan.nextLine());
        double statues = rent*0.7;
        double catering = statues*0.85;
        double sounding = catering*0.5;

        double sum = rent+statues+catering+sounding;

        System.out.printf("%.2f",sum);
    }
}
