package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class FavoriteMovie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int counter = 0;
        String bestMovie = "";
        int mostPoints = 0;

        while (!"STOP".equals(input)){

            String movieName = input;
            int points = 0;
            int countUpper = 0;
            int countLower = 0;
            for (int i = 0; i <movieName.length() ; i++) {

                int digit = movieName.charAt(i);
                if (digit>='A'&&digit<='Z'){
                    countUpper++;
                }else if (digit>='a'&&digit<='z'){
                    countLower++;
                }
                points+=digit;
            }
            points=points-(countUpper*movieName.length()) - (countLower*movieName.length()*2);
            if (points>mostPoints){
                mostPoints=points;
                bestMovie=movieName;
            }

            counter++;
            if (counter>=7){
                break;
            }
            input= scan.nextLine();
        }
        if (counter==7){
            System.out.println("The limit is reached.");
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.",bestMovie,mostPoints);
    }
}
