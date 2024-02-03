package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class _8_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] chamber = new String[15][15];
        int[] playerPosition = new int[]{7, 7};
        int playerHP = 18500;
        double heiganHP = 3000000;

        double damage = Double.parseDouble(scan.nextLine());
        String lethalitySpell = "";

        boolean isPlayerDead = false;
        boolean isHeiganDead = false;
        boolean hasCloud = false;

        while (true) {
            String[] inputData = scan.nextLine().split("\\s+");
            String spell = inputData[0];
            int hitRow = Integer.parseInt(inputData[1]);
            int hitCol = Integer.parseInt(inputData[2]);
            heiganHP -= damage;
            if (heiganHP <= 0) {
                isHeiganDead = true;
            }
            if (hasCloud) {
                playerHP -= 3500;
                hasCloud = false;
                lethalitySpell = "Plague Cloud";
                if (playerHP <= 0) {
                    isPlayerDead = true;
                }
            }
            if (isPlayerDead || isHeiganDead) {
                break;
            }
            if (isInDamageZone(playerPosition, hitRow, hitCol)) {
                if (playerPosition[0] > 0 && playerPosition[0] < hitRow) {
                    playerPosition[0]--;
                } else if (playerPosition[1] < 15 && playerPosition[1] > hitCol) {
                    playerPosition[1]++;
                } else if (playerPosition[0] < 15 && playerPosition[0] > hitRow) {
                    playerPosition[0]++;
                } else if (playerPosition[1] > 0 && playerPosition[1] < hitCol) {
                    playerPosition[1]--;
                } else {
                    if (spell.equals("Cloud")) {
                        playerHP -= 3500;
                        hasCloud = true;
                        lethalitySpell = "Plague Cloud";
                    } else if (spell.equals("Eruption")) {
                        playerHP -= 6000;
                        lethalitySpell = "Eruption";
                    }
                }
            }
            if (playerHP <= 0) {
                isPlayerDead = true;
                break;
            }
        }
        if (isHeiganDead) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHP);
        }
        if (isPlayerDead) {
            System.out.printf("Player: Killed by %s\n", lethalitySpell);
        } else {
            System.out.printf("Player: %d\n", playerHP);
        }
        System.out.printf("Final position: %d, %d\n", playerPosition[0], playerPosition[1]);
    }

    private static boolean isInDamageZone(int[] playerPosition, int hitRow, int hitCol) {
        return playerPosition[0] >= hitRow - 1
                && playerPosition[0] <= hitRow + 1
                && playerPosition[1] >= hitCol - 1
                && playerPosition[1] <= hitCol + 1;
    }
}
