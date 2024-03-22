package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.core.interfaces.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.cars.Car;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.cars.MuscleCar;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.cars.SportsCar;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.drivers.Driver;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.drivers.DriverImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.races.Race;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.races.RaceImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.common.ExceptionMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS,driver));
        }
        Driver driver1 = new DriverImpl(driver);
        driverRepository.add(driver1);
        return String.format(DRIVER_CREATED,driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS,model));
        }
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }
        carRepository.add(car);
        return String.format(CAR_CREATED,car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }
        Car car = carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND,carModel));
        }
        driver.addCar(car);
        return String.format(CAR_ADDED,driverName,carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }
        race.addDriver(driver);
        return String.format(DRIVER_ADDED,driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }
        int laps = race.getLaps();
        List<Driver> drivers = race.getDrivers().stream()
                .sorted((f,s) -> (int) (s.getCar().calculateRacePoints(laps) - f.getCar().calculateRacePoints(laps))).limit(3).collect(Collectors.toList());
        raceRepository.remove(race);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(DRIVER_FIRST_POSITION,drivers.get(0).getName(),raceName)).append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION,drivers.get(1).getName(),raceName)).append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION,drivers.get(2).getName(),raceName));

        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS,name));
        }
        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED,name);
    }
}
