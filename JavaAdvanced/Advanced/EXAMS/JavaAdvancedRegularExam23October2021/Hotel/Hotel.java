package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam23October2021.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }
    public boolean remove(String name) {
        return roster.removeIf(p -> p.getName().equals(name));
    }
    public Person getPerson(String name,String hometown) {
        return roster.stream()
                .filter(p -> p.getName().equals(name)).filter(p -> p.getHometown().equals(hometown)).findFirst().orElse(null);
    }
    public int getCount() {
        return roster.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        roster.forEach(p -> sb.append(p).append("\n"));
        return String.format("The people in the hotel %s are:\n%s",getName(),sb.toString().trim());
    }
}
