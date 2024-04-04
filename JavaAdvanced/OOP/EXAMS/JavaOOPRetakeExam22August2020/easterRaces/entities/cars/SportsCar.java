package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.entities.cars;

public class SportsCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS = 3000;
    private static final int MIN_HORSEPOWER = 250;
    private static final int MAX_HORSEPOWER = 450;
    public SportsCar(String model, int horsePower) {
        super(model, MIN_HORSEPOWER, MAX_HORSEPOWER, horsePower, CUBIC_CENTIMETERS);
    }
}
