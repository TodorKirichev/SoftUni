package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.common.ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY;

public class PlanetImpl implements Planet {
    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        setName(name);
        items = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }
}
