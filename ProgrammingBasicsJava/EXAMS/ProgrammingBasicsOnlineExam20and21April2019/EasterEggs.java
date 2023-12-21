package ProgrammingBasicsOnlineExam20and21April2019;

import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int eggs = Integer.parseInt(scan.nextLine());
        int red = 0;
        int orange = 0;
        int blue = 0;
        int green = 0;
        int most = 0;
        String eggColor = "";

        for (int i = 0; i < eggs; i++) {

            String color = scan.nextLine();

            switch (color){
                case "red":
                    red++;
                    if (red>most){
                        most=red;
                        eggColor="red";
                    }
                    break;
                case "orange":
                    orange++;
                    if (orange>most){
                        most=orange;
                        eggColor="orange";
                    }
                    break;
                case "blue":
                    blue++;
                    if (blue>most){
                        most=blue;
                        eggColor="blue";
                    }
                    break;
                case "green":
                    green++;
                    if (green>most){
                        most=green;
                        eggColor="green";
                    }
                    break;
            }
        }
        System.out.printf("Red eggs: %d%n",red);
        System.out.printf("Orange eggs: %d%n",orange);
        System.out.printf("Blue eggs: %d%n",blue);
        System.out.printf("Green eggs: %d%n",green);
        System.out.printf("Max eggs: %d -> %s",most,eggColor);
    }
}
