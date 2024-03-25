package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;

public class StateRepository implements Repository<State> {
    private Collection<State> states;

    public StateRepository() {
        states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return states;
    }

    @Override
    public void add(State state) {
        states.add(state);
    }

    @Override
    public boolean remove(State state) {
        return states.remove(state);
    }

    @Override
    public State byName(String name) {
        return states.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
