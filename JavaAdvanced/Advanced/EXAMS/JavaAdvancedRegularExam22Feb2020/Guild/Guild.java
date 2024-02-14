package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam22Feb2020.Guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }
    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }
    public boolean removePlayer(String name) {
        return roster.removeIf(p -> p.getName().equals(name));
    }
    public void promotePlayer(String name) {
        roster.stream().filter(p -> p.getName().equals(name)).findFirst().get().setRank("Member");
    }
    public void demotePlayer(String name) {
        roster.stream().filter(p -> p.getName().equals(name)).findFirst().get().setRank("Trial");
    }
    public Player[] kickPlayersByClass(String clazz) {
        Player[] list = roster.stream().filter(p -> p.getClazz().equals(clazz)).toArray(Player[]::new);
        roster = roster.stream().filter(p -> !p.getClazz().equals(clazz)).collect(Collectors.toList());
        return list;
    }
    public int count() {
        return roster.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        roster.forEach(p -> sb.append(p).append(System.lineSeparator()));
        return String.format("\nPlayers in the guild: %s:\n%s",name,sb.toString().trim());
    }
}
