package ProgrammingFundamentalsFinalExam02;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();

        while (!input.equals("Travel")) {

            String command = input.split(":")[0];
            if (command.contains("Add")) {
                int index = Integer.parseInt(input.split(":")[1]);
                String stop = input.split(":")[2];
                if (index >= 0 && index < stops.length()) {
                    stops.insert(index,stop);
                }
            } else if (command.contains("Remove")) {
                int startIndex = Integer.parseInt(input.split(":")[1]);
                int endIndex = Integer.parseInt(input.split(":")[2]);
                if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
                    stops.replace(startIndex,endIndex + 1,"");
                }
            } else if (command.contains("Switch")) {
                String oldStop = input.split(":")[1];
                String newStop = input.split(":")[2];
                int index = stops.indexOf(oldStop);
                if (index != -1) {
                    stops.replace(index,index + oldStop.length(),"");
                    stops.insert(index,newStop);
                }
            }
            System.out.println(stops);
            input = scan.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s\n",stops);
    }
}