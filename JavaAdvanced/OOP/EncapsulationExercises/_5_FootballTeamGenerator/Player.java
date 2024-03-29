package SoftUni.JavaAdvanced.OOP.EncapsulationExercises._5_FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (isValid(endurance,"Endurance")) {
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if (isValid(sprint,"Sprint")) {
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if (isValid(dribble,"Dribble")) {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (isValid(passing,"Passing")) {
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if (isValid(shooting,"Shooting")) {
            this.shooting = shooting;
        }
    }

    private static boolean isValid(int value,String msg) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.",msg));
        }
        return true;
    }
    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }
}
