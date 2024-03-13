package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.common.ConstantMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.common.ExceptionMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver.DeepWaterDiver;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver.Diver;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver.OpenWaterDiver;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver.WreckDiver;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diving.Diving;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diving.DivingImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.divingSite.DivingSite;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.divingSite.DivingSiteImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.repositories.DiverRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.repositories.DivingSiteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DiverRepository diverRepository;
    private DivingSiteRepository divingSiteRepository;
    private int countDivingSites;

    public ControllerImpl() {
        diverRepository = new DiverRepository();
        divingSiteRepository = new DivingSiteRepository();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver = null;
        switch (kind) {
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }
        diverRepository.add(diver);
        return String.format(ConstantMessages.DIVER_ADDED,kind,diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        for (String seaCreature : seaCreatures) {
            divingSite.getSeaCreatures().add(seaCreature);
        }
        divingSiteRepository.add(divingSite);
        return String.format(ConstantMessages.DIVING_SITE_ADDED,siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);
        if (diver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST,diverName));
        }
        return String.format(ConstantMessages.DIVER_REMOVE,diverName);
    }

    @Override
    public String startDiving(String siteName) {
        DivingSite divingSite = divingSiteRepository.byName(siteName);
        List<Diver> divers = diverRepository.getCollection().stream()
                .filter(d -> d.getOxygen() > 30).collect(Collectors.toList());
        if (divers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }
        Diving diving = new DivingImpl();
        diving.searching(divingSite,divers);
        countDivingSites++;
        long removedDivers = divers.stream()
                .filter(d -> d.getOxygen() == 0)
                .count();
        return String.format(ConstantMessages.SITE_DIVING,siteName,removedDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_DIVING_SITES,countDivingSites));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_DIVERS_STATISTICS);
        sb.append(System.lineSeparator());

        for (Diver diver : diverRepository.getCollection()) {
            sb.append(String.format(ConstantMessages.FINAL_DIVER_NAME,diver.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN,diver.getOxygen()));
            sb.append(System.lineSeparator());
            if (diver.getSeaCatch().getSeaCreatures().isEmpty()) {
                sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH,"None"));
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH,String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER,diver.getSeaCatch().getSeaCreatures())));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
