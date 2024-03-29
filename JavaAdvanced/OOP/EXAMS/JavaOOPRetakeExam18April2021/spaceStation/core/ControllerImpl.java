package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts.Astronaut;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts.Biologist;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts.Geodesist;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts.Meteorologist;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.mission.Mission;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.mission.MissionImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.planets.Planet;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.planets.PlanetImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.repositories.AstronautRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.repositories.PlanetRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
        exploredPlanetsCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Collection<Astronaut> astronauts = astronautRepository.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = planetRepository.findByName(planetName);
        Mission mission = new MissionImpl();
        mission.explore(planet,astronauts);
        exploredPlanetsCount++;
        long deadAstronauts = astronauts.stream().filter(a -> !a.canBreath()).count();

        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanetsCount)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : astronautRepository.getModels()) {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator());
            sb.append("Bag items: ");
            if (astronaut.getBag().getItems().isEmpty()) {
                sb.append("none");
            } else {
                String items = String.join(", ", astronaut.getBag().getItems());
                sb.append(items);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
