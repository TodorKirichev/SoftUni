package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.common.ExceptionMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.roster.Roster;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.roster.RosterImpl;

public abstract class BaseClimber implements Climber{
    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        setName(name);
        setStrength(strength);
        roster = new RosterImpl();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public Roster getRoster() {
        return roster;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

        @Override
    public boolean canClimb() {
        return strength > 0;
    }

    @Override
    public abstract void climb();
}
