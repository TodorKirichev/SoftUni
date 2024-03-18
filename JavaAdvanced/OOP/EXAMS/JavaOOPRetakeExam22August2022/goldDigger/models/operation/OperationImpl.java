package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.operation;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.discoverer.Discoverer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.stream.Collectors;

public class OperationImpl implements Operation {
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        discoverers = discoverers.stream().filter(d -> d.getEnergy() > 0).collect(Collectors.toList());
        Collection<String> exhibits = spot.getExhibits();

        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig() && exhibits.iterator().hasNext()) {
                String exhibit = exhibits.iterator().next();
                discoverer.dig();
                discoverer.getMuseum().getExhibits().add(exhibit);
                exhibits.remove(exhibit);
            }
        }
    }
}
