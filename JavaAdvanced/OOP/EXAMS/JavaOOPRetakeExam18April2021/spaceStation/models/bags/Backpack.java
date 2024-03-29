package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

public class Backpack implements Bag {
    private Collection<String> items;

    public Backpack() {
        items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }
}
