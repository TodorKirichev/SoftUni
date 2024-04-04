package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.entities.cars;

public class MuscleCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS = 5000;
    private static final int MIN_HORSEPOWER = 400;
    private static final int MAX_HORSEPOWER = 600;
    public MuscleCar(String model, int horsePower) {
        super(model, MIN_HORSEPOWER, MAX_HORSEPOWER, horsePower, CUBIC_CENTIMETERS);
    }
}
