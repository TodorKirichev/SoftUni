package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.mission;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts.Astronaut;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<Astronaut> astronautsLeft = astronauts.stream()
                .filter(Astronaut::canBreath).collect(Collectors.toList());

        Collection<String> items = planet.getItems();

        for (Astronaut astronaut : astronautsLeft) {
            while (astronaut.canBreath() && !items.isEmpty()) {
                String item = items.iterator().next();
                astronaut.breath();
                astronaut.getBag().getItems().add(item);
                items.remove(item);
            }
        }

    }
}
