package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.operation;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.discoverer.Discoverer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.spot.Spot;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}
