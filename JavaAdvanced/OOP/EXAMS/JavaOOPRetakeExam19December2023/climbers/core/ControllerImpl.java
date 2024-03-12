package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.common.ConstantMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.common.ExceptionMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber.Climber;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber.RockClimber;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber.WallClimber;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climbing.Climbing;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climbing.ClimbingImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.mountain.Mountain;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.mountain.MountainImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.repositories.ClimberRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.repositories.MountainRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;

public class ControllerImpl implements Controller{

    private Repository<Climber> climberRepository;
    private Repository<Mountain> mountainRepository;

    private int mountains;

    public ControllerImpl() {
        climberRepository = new ClimberRepository();
        mountainRepository = new MountainRepository();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        switch (type) {
            case "RockClimber":
                climber = new RockClimber(climberName);
                break;
            case "WallClimber":
                climber = new WallClimber(climberName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
        }
        climberRepository.add(climber);
        return String.format(ConstantMessages.CLIMBER_ADDED,type,climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        mountainRepository.add(mountain);
        return String.format(ConstantMessages.MOUNTAIN_ADDED,mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = climberRepository.byName(climberName);
        if (climber == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST,climberName));
        }
        climberRepository.remove(climber);
        return String.format(ConstantMessages.CLIMBER_REMOVE,climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        if (climberRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
        }
        Collection<Climber> climbers = climberRepository.getCollection();
        Mountain mountain = mountainRepository.byName(mountainName);
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain,climbers);
        long removed = climbers.stream().filter(d -> d.getStrength() == 0).count();
        return String.format(ConstantMessages.PEAK_CLIMBING,mountainName,removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

    }
}
