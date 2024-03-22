package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.cars;

public class MuscleCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS = 5000;
    private static final int MIN_HORSEPOWER = 400;
    private static final int MAX_HORSEPOWER = 600;


    public MuscleCar(String model, int horsePower) {
        super(model, 0, CUBIC_CENTIMETERS);
        setHorsePower(horsePower,MIN_HORSEPOWER,MAX_HORSEPOWER);
    }
}
