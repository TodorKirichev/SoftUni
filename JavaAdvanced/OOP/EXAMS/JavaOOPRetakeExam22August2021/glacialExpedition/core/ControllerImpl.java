package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.explorers.AnimalExplorer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.explorers.Explorer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.explorers.GlacierExplorer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.explorers.NaturalExplorer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.mission.Mission;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.mission.MissionImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.states.State;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.states.StateImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.repositories.ExplorerRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int exploredStatesCount;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
        exploredStatesCount = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        stateRepository.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorer);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = stateRepository.byName(stateName);
        Collection<Explorer> explorers = explorerRepository.getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(state, explorers);
        exploredStatesCount++;

        int retiredExplorersCount = (int) explorers.stream().filter(e -> !e.canSearch()).count();
        return String.format(STATE_EXPLORER, stateName, retiredExplorersCount);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_STATE_EXPLORED, exploredStatesCount)).append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());
        for (Explorer explorer : explorerRepository.getCollection()) {
            sb.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());
            sb.append("Suitcase exhibits: ");
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                sb.append("None");
            } else {
                sb.append(String.join(", ", explorer.getSuitcase().getExhibits()));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
