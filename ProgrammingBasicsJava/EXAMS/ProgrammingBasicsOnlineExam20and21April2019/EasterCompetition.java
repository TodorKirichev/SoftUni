package ProgrammingBasicsOnlineExam20and21April2019;

import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bread = Integer.parseInt(scan.nextLine());
        String newWinner = "";
        int newPoints = 0;

        for (int i = 0; i <bread ; i++) {

            String name = scan.nextLine();
            String input = scan.nextLine();
            int points = 0;

            while (!"Stop".equals(input)){

                int mark = Integer.parseInt(input);
                points+=mark;

                input= scan.nextLine();
            }
            System.out.printf("%s has %d points.%n",name,points);
            if (points>newPoints){
                newPoints=points;
                newWinner=name;
                System.out.printf("%s is the new number 1!%n",name);
            }
        }
        System.out.printf("%s won competition with %d points!%n",newWinner,newPoints);
    }

}
