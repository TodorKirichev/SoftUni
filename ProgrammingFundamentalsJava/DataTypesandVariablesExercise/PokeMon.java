package DataTypesandVariablesExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int power = Integer.parseInt(scan.nextLine());
        int startingPower = power;
        int distance = Integer.parseInt(scan.nextLine());
        int exFactor = Integer.parseInt(scan.nextLine());
        int targetsCount = 0;

        while (power>=distance){

            if (startingPower/2==power && exFactor!=0){
                power/=exFactor;
            }
            if (power<distance){
                break;
            }else {
                targetsCount++;
                power-=distance;
            }
        }
        System.out.println(power);
        System.out.println(targetsCount);
    }
}
