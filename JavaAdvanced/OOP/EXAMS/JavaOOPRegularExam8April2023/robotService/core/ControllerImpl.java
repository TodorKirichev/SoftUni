package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.robot.FemaleRobot;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.robot.MaleRobot;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.robot.Robot;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.services.MainService;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.services.SecondaryService;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.services.Service;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.supplements.MetalArmor;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.supplements.PlasticArmor;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.supplements.Supplement;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.common.ExceptionMessages.*;


public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    private Service findService(String serviceName) {
        return services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        switch (type) {
            case "MainService":
                service = new MainService(name);
                break;
            case "SecondaryService":
                service = new SecondaryService(name);
                break;
            default:
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE,type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE,type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = supplements.findFirst(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND,supplementType));
        }
        Service service = findService(serviceName);
        service.addSupplement(supplement);
        supplements.removeSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE,supplementType,serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName,robotKind,price);
                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName,robotKind,price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        Service service = findService(serviceName);

        boolean isSuitable = robotType.equals("MaleRobot") && service.getClass().getSimpleName().equals("MainService") ||
                robotType.equals("FemaleRobot") && service.getClass().getSimpleName().equals("SecondaryService");
        if (isSuitable) {
            service.addRobot(robot);
            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE,robotType,serviceName);
        } else {
            return UNSUITABLE_SERVICE;
        }
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = findService(serviceName);
        service.feeding();
        return String.format(FEEDING_ROBOT,service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = findService(serviceName);
        double sum = 0;
        for (Robot robot : service.getRobots()) {
            sum += robot.getPrice();
        }
        for (Supplement supplement : service.getSupplements()) {
            sum += supplement.getPrice();
        }
        return String.format(VALUE_SERVICE,serviceName,sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        services.forEach(s -> sb.append(s.getStatistics()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
