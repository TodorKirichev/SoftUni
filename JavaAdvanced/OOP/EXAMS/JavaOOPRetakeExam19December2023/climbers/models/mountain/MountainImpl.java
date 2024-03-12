package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.mountain;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class MountainImpl implements Mountain{
    private String name;
    private Collection<String> peakList;

    public MountainImpl(String name) {
        setName(name);
        peakList = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.MOUNTAIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getPeaksList() {
        return peakList;
    }

    @Override
    public String getName() {
        return name;
    }
}
