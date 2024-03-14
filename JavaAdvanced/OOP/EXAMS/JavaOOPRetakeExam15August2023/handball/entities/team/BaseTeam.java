package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.team;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.common.ExceptionMessages.*;

public abstract class BaseTeam implements Team {
    private String name;
    private String country;
    private int advantage;

    protected BaseTeam(String name, String country, int advantage) {
        setName(name);
        setCountry(country);
        setAdvantage(advantage);
    }

    protected void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new NullPointerException(TEAM_COUNTRY_NULL_OR_EMPTY);
        }
        this.country = country;
    }

    protected void setAdvantage(int advantage) {
        if (advantage <= 0) {
            throw new IllegalArgumentException(TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }
        this.advantage = advantage;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(TEAM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public abstract void play();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAdvantage() {
        return advantage;
    }
}
