package ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int countRed = 0;
        int countOrange = 0;
        int countYellow = 0;
        int countWhite = 0;
        int countBlack = 0;
        int countOthers = 0;
        int points = 0;

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            switch (input){
                case "red":
                    points+=5;
                    countRed++;
                    break;
                case "orange":
                    points+=10;
                    countOrange++;
                    break;
                case "yellow":
                    points+=15;
                    countYellow++;
                    break;
                case "white":
                    points+=20;
                    countWhite++;
                    break;
                case "black":
                    points= (int) Math.floor(points/2.0);
                    countBlack++;
                    break;
                default:
                    countOthers++;
                    break;
            }
        }
        System.out.printf("Total points: %d%n",points);
        System.out.printf("Red balls: %d%n",countRed);
        System.out.printf("Orange balls: %d%n",countOrange);
        System.out.printf("Yellow balls: %d%n",countYellow);
        System.out.printf("White balls: %d%n",countWhite);
        System.out.printf("Other colors picked: %d%n",countOthers);
        System.out.printf("Divides from black balls: %d%n",countBlack);
    }
}
