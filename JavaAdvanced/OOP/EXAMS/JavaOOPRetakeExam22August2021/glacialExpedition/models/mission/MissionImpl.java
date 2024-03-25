package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.mission;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.explorers.Explorer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        explorers = explorers.stream().filter(e -> e.getEnergy() > 0).collect(Collectors.toList());
        Iterator<String> exhibits = state.getExhibits().iterator();

        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && exhibits.hasNext()) {
                String exhibit = exhibits.next();
                explorer.search();
                explorer.getSuitcase().getExhibits().add(exhibit);
            }
        }
    }
}
