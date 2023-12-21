import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int health = 100;
        int bitcoins = 0;

        String [] rooms = scan.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            String [] input = rooms[i].split(" ");
            String command = input[0];
            int value = Integer.parseInt(input[1]);

            switch (command){
                case "potion":
                    int heal = 100 - health;
                    health = Math.min(100,health + value);
                    System.out.printf("You healed for %d hp.%n",Math.min(value,heal));
                    System.out.printf("Current health: %d hp.%n",health);
                    break;
                case "chest":
                    bitcoins += value;
                    System.out.printf("You found %d bitcoins.%n",value);
                    break;
                default:
                    health -= value;
                    if (health > 0){
                        System.out.printf("You slayed %s.%n",command);
                    }else{
                        System.out.printf("You died! Killed by %s.%n",command);
                        System.out.printf("Best room: %d",i + 1);
                        return;
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%n");
        System.out.printf("Bitcoins: %d%n",bitcoins);
        System.out.printf("Health: %d%n",health);
    }
}
