package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class MovieDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int timeForRecord = Integer.parseInt(scan.nextLine());
        int numScenes = Integer.parseInt(scan.nextLine());
        int timePerScene = Integer.parseInt(scan.nextLine());

        double minutes = (timeForRecord*0.15)+numScenes*timePerScene;

        if (minutes<=timeForRecord){
            System.out.printf("You managed to finish the movie on time! You have %d minutes left!",Math.round(timeForRecord-minutes));
        }else{
            System.out.printf("Time is up! To complete the movie you need %d minutes.",Math.round(minutes-timeForRecord));
        }


    }
}
