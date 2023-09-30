package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int soldGames = Integer.parseInt(scan.nextLine());
        int countHearth = 0;
        int countFronite = 0;
        int countOver = 0;
        int countOthers = 0;

        for (int i = 0; i < soldGames; i++) {
            String gameName = scan.nextLine();

            if (gameName.equals("Hearthstone")){
                countHearth++;
            } else if (gameName.equals("Fornite")) {
                countFronite++;
            } else if (gameName.equals("Overwatch")) {
                countOver++;
            }else {
                countOthers++;
            }

        }
        System.out.printf("Hearthstone - %.2f%%%n",(double)countHearth/soldGames*100);
        System.out.printf("Fornite - %.2f%%%n",(double)countFronite/soldGames*100);
        System.out.printf("Overwatch - %.2f%%%n",(double)countOver/soldGames*100);
        System.out.printf("Others - %.2f%%%n",(double)countOthers/soldGames*100);
        }
    }