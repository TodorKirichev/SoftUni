package SoftUni.JavaAdvanced.OOP.EncapsulationExercises._5_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Team> teams = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] commandParts = input.split(";");

            try {
                String command = commandParts[0];
                String teamName = commandParts[1];
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName,team);
                        break;
                    case "Add":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.\n",teamName);
                        } else {
                            String playerName = commandParts[2];
                            int endurance = Integer.parseInt(commandParts[3]);
                            int sprint = Integer.parseInt(commandParts[4]);
                            int dribble = Integer.parseInt(commandParts[5]);
                            int passing = Integer.parseInt(commandParts[6]);
                            int shooting = Integer.parseInt(commandParts[7]);
                            Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
                            teams.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerName = commandParts[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.\n",teamName);
                        } else {
                            System.out.printf("%s - %d\n",teamName,Math.round(teams.get(teamName).getRating()));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scan.nextLine();
        }
        System.out.println();
    }
}
