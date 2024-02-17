package SoftUni.JavaAdvanced.Advanced.EXAMS.Exam.ex2;

import java.util.Scanner;

public class ClearSkies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] airspace = new char[size][size];

        int jetFighterRow = 0;
        int jetFighterCol = 0;

        for (int row = 0; row < airspace.length; row++) {
            String line = scan.nextLine();
            for (int col = 0; col < airspace[row].length; col++) {
                airspace[row][col] = line.charAt(col);
                if (airspace[row][col] == 'J') {
                    jetFighterRow = row;
                    jetFighterCol = col;
                }
            }
        }
        int armour = 300;
        int shootedPlanes = 0;

        boolean isJetFighterShooted = false;
        boolean isAllEnemiesDown = false;

        String command = scan.nextLine();

        while (true) {
            airspace[jetFighterRow][jetFighterCol] = '-';

            switch (command) {
                case "up":
                    jetFighterRow--;
                    break;
                case "down":
                    jetFighterRow++;
                    break;
                case "left":
                    jetFighterCol--;
                    break;
                case "right":
                    jetFighterCol++;
                    break;
            }
            if (airspace[jetFighterRow][jetFighterCol] == 'E') {
                shootedPlanes++;
                airspace[jetFighterRow][jetFighterCol] = '-';
                if (shootedPlanes < 4) {
                    armour -= 100;
                    if (armour == 0) {
                        isJetFighterShooted = true;
                        break;
                    }
                } else {
                    isAllEnemiesDown = true;
                    break;
                }
            }
            if (airspace[jetFighterRow][jetFighterCol] == 'R') {
                airspace[jetFighterRow][jetFighterCol] = '-';
                armour = 300;
            }
            command = scan.nextLine();
        }
        airspace[jetFighterRow][jetFighterCol] = 'J';
        if (isAllEnemiesDown) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }
        if (isJetFighterShooted) {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n"
            ,jetFighterRow,jetFighterCol);
        }
        print(airspace);
    }

    private static void print(char[][] airspace) {
        for (int row = 0; row < airspace.length; row++) {
            for (int col = 0; col < airspace[row].length; col++) {
                System.out.print(airspace[row][col]);
            }
            System.out.println();
        }
    }
}
