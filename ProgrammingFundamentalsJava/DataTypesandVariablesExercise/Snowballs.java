package DataTypesandVariablesExercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int snowballsMade = Integer.parseInt(scan.nextLine());
        double snowballValue = 0;
        int snowballSnow = 0;
        int snowballTime = 0;
        int snowballQuality = 0;

        for (int i = 0; i < snowballsMade; i++) {
            int snow = Integer.parseInt(scan.nextLine());
            int time = Integer.parseInt(scan.nextLine());
            int quality = Integer.parseInt(scan.nextLine());

            double value =  Math.pow( snow /time,quality);
            if (value>snowballValue){
                snowballValue=value;
                snowballSnow=snow;
                snowballTime=time;
                snowballQuality=quality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",snowballSnow,snowballTime,snowballValue,snowballQuality);
    }
}
