package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.enums.State;
import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces.IMission;

public class Mission implements IMission {
    private String codeName;
    private State state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    public void setState(String state) {
        if (!state.equals("inProgress") && !state.equals("finished")) {
            throw new IllegalArgumentException();
        }
        this.state = State.valueOf(state);
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void completeMission() {
        state = State.finished;
    }
    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s",codeName,state);
    }
}
