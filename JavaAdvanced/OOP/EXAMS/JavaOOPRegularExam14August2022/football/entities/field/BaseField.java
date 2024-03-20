package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.field;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.player.Player;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumEnergy() {
        return supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):",getName(), getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Player: ");
        if (players.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Supplement: %d",supplements.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Energy: %d",sumEnergy()));
        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}
