package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int sum = 0;
        int points = 0;
        String winner = "";
        while (!name.equals("Stop")){

            for (int i = 0; i < name.length(); i++) {
                int num = Integer.parseInt(scan.nextLine());
                if (num==name.charAt(i)){
                    sum+=10;
                }else {
                    sum += 2;
                }
            }
            if (sum>=points){
                points=sum;
                winner=name;
            }
            sum=0;
            name = scan.nextLine();
        }
        System.out.printf("The winner is %s with %d points!",winner,points);
    }
}
