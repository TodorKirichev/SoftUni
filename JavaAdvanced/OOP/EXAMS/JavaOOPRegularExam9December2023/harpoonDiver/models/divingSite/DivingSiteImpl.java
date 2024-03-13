package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.divingSite;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class DivingSiteImpl implements DivingSite{
    private String name;
    private Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {
        setName(name);
        seaCreatures = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }

    @Override
    public String getName() {
        return name;
    }
}
