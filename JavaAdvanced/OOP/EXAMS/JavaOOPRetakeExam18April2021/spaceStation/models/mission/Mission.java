package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.mission;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts.Astronaut;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
