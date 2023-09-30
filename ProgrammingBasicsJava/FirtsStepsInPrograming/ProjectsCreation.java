package firtsStepsInPrograming;

import java.util.Scanner;

import static javax.swing.text.html.HTML.Tag.S;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int numOfProj = Integer.parseInt(scan.nextLine());
        System.out.print("The architect " + name + " will need " + numOfProj*3 + " hours to complete " + numOfProj + " project/s.");
    }
}
