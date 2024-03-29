package SoftUni.JavaAdvanced.OOP.EncapsulationExercises._5_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public void removePlayer(String name) {
        boolean contains = players.removeIf(p -> p.getName().equals(name));
        if (!contains) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",name,getName()));
        }
    }
    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
