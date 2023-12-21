package ProgrammingFundamentalsMidExamRetake_6;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int [] warship = Arrays.stream(scan.nextLine().split(">"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int maxHealth = Integer.parseInt(scan.nextLine());

        String commandName = scan.nextLine();

        while (!commandName.equals("Retire")){
            String [] input = commandName.split(" ");
            String command = input[0];
            switch (command){

                case "Fire":
                     int indexFire = Integer.parseInt(input[1]);
                     int damageToWarship = Integer.parseInt(input[2]);
                    if (checkIndex(warship,indexFire)){
                        warship[indexFire] -= damageToWarship;
                        if (warship[indexFire] <= 0){
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(input[1]);
                    int endIndex = Integer.parseInt(input[2]);
                    int damageToPirateShip = Integer.parseInt(input[3]);
                    if (checkIndex(pirateShip,startIndex) && checkIndex(pirateShip,endIndex)){
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= damageToPirateShip;
                            if (pirateShip[i] <= 0){
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(input[1]);
                    int health = Integer.parseInt(input[2]);
                    if (checkIndex(pirateShip,indexRepair)){
                        if (pirateShip[indexRepair] < maxHealth){
                            pirateShip[indexRepair] += health;
                            if (pirateShip[indexRepair] > maxHealth){
                                pirateShip[indexRepair] = maxHealth;
                            }
                        }
                    }
                    break;
                case "Status":
                    double minHealth = maxHealth * 0.2;
                    int countSection = 0;
                    for (int i = 0; i < pirateShip.length; i++) {
                        if (pirateShip[i] < minHealth){
                            countSection++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n",countSection);
                    break;
            }
            commandName = scan.nextLine();
        }
        int pirateShipSum = 0;
        int warshipSum = 0;
        for (int i = 0; i < pirateShip.length; i++) {
            pirateShipSum += pirateShip[i];
        }
        for (int i = 0; i < warship.length; i++) {
            warshipSum += warship[i];
        }
        System.out.printf("Pirate ship status: %d%n",pirateShipSum);
        System.out.printf("Warship status: %d%n",warshipSum);
    }
    public static boolean checkIndex (int [] array,int index){
        return index >= 0 && index <array.length;
    }
}
