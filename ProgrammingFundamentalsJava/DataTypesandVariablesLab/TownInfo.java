package DataTypesandVariablesLab;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nameTown = scan.nextLine();
        int population = Integer.parseInt(scan.nextLine());
        int area = Integer.parseInt(scan.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.",nameTown,population,area);
    }
}
