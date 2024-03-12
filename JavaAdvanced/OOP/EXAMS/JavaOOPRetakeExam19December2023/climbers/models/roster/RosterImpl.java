package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.roster;

import java.util.ArrayList;
import java.util.Collection;

public class RosterImpl implements Roster{
    private Collection<String> peaks;

    public RosterImpl() {
        this.peaks = new ArrayList<>();
    }

    @Override
    public Collection<String> getPeaks() {
        return peaks;
    }
}
